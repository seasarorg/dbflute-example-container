/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.allcommon;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.UnsatisfiedResolutionException;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;
import javax.sql.DataSource;

import org.seasar.dbflute.BehaviorSelector;
import org.seasar.dbflute.bhv.AbstractBehaviorReadable;
import org.seasar.dbflute.bhv.AbstractBehaviorWritable;
import org.seasar.dbflute.bhv.core.BehaviorCommandInvoker;
import org.seasar.dbflute.bhv.core.CommonColumnAutoSetupper;
import org.seasar.dbflute.bhv.core.InvokerAssistant;
import org.seasar.dbflute.cbean.sqlclause.SqlClauseCreator;

import com.example.dbflute.cdi.dbflute.exbhv.*;

/**
 * {@link Extension} for DBFlute.
 * @author DBFlute(AutoGenerator)
 */
public class DBFluteModule implements Extension {

    // ===================================================================================
    //                                                                           Qualifier
    //                                                                           =========
    /** DBFlute qualifier. */
    @Qualifier
    @Retention(RUNTIME)
    @Target({TYPE, METHOD, FIELD, PARAMETER})
    public @interface DBFlute {}

    // ===================================================================================
    //                                                                         Set up Bean
    //                                                                         ===========
    /**
     * Register DBFlute beans to container.
     * @param event The event type after bean discovery process. (NotNull)
     * @param beanManager The manager of CDI beans. (NotNull)
     */
    public void afterBeanDiscovery(@Observes final AfterBeanDiscovery event, final BeanManager beanManager) {
        setupDfComponents(event, beanManager);
        setupBehaviors(event, beanManager);
    }

    /**
     * Register environment dependent implementations to container.
     * @param event The event type after bean discovery process. (NotNull)
     * @param beanManager The manager of CDI beans. (NotNull)
     */
    protected void setupDfComponents(final AfterBeanDiscovery event, final BeanManager beanManager) {
        event.addBean(newDBFluteBeanOfInvokerAssistant(beanManager));
        event.addBean(newDBFluteBeanOfCommonColumnAutoSetupper(beanManager));
        event.addBean(newDBFluteBeanOfBehaviorSelector(beanManager));
        event.addBean(newDBFluteBeanOfSqlClauseCreator(beanManager));
        event.addBean(newDBFluteBeanOfBehaviorCommandInvoker(beanManager));
    }

    /**
     * Register behaviors to container.
     * @param event The event type after bean discovery process. (NotNull)
     * @param beanManager The manager of CDI beans. (NotNull)
     */
    protected void setupBehaviors(final AfterBeanDiscovery event, final BeanManager beanManager) {
        final List<Class<? extends AbstractBehaviorReadable>> typeList = new ArrayList<Class<? extends AbstractBehaviorReadable>>();
        typeList.add(MemberBhv.class);
        typeList.add(MemberAddressBhv.class);
        typeList.add(MemberLoginBhv.class);
        typeList.add(MemberSecurityBhv.class);
        typeList.add(MemberServiceBhv.class);
        typeList.add(MemberStatusBhv.class);
        typeList.add(MemberWithdrawalBhv.class);
        typeList.add(ProductBhv.class);
        typeList.add(ProductCategoryBhv.class);
        typeList.add(ProductStatusBhv.class);
        typeList.add(PurchaseBhv.class);
        typeList.add(RegionBhv.class);
        typeList.add(ServiceRankBhv.class);
        typeList.add(SummaryProductBhv.class);
        typeList.add(SummaryWithdrawalBhv.class);
        typeList.add(VendorCheckBhv.class);
        typeList.add(WithdrawalReasonBhv.class);
        doSetupBehaviors(event, beanManager, typeList);
    }

    /**
     * Actually register behaviors to container.
     * @param event The event type after bean discovery process. (NotNull)
     * @param beanManager The manager of CDI beans. (NotNull)
     * @param typeList The list of behavior types to be registered. (NotNull)
     */
    protected void doSetupBehaviors(final AfterBeanDiscovery event, final BeanManager beanManager, final List<Class<? extends AbstractBehaviorReadable>> typeList) {
        for (Class<? extends AbstractBehaviorReadable> clazz : typeList) {
            event.addBean(newBehaviorBean(beanManager, clazz));
        }
    }

    /**
     * Initialize DBFlute.
     * @param event The event type after deployment validation process. (NotNull)
     */
    public void afterDeploymentValidation(@Observes final AfterDeploymentValidation event) {
        initializeDBFlute();
    }

    /**
     * Initialize DBFlute (by creating DBFlute initializer).
     */
    protected void initializeDBFlute() {
        new com.example.dbflute.cdi.dbflute.allcommon.DBFluteInitializer();
    }

    // ===================================================================================
    //                                                                        DBFlute Bean
    //                                                                        ============
    /**
     * New DBFlute bean for invoker assistant.
     * @param beanManager The manager of CDI beans. (NotNull)
     * @return The new-created DBFlute bean. (NotNull)
     */
    protected DBFluteBean<com.example.dbflute.cdi.dbflute.allcommon.ImplementedInvokerAssistant> newDBFluteBeanOfInvokerAssistant(final BeanManager beanManager) {
        return new DBFluteBean<com.example.dbflute.cdi.dbflute.allcommon.ImplementedInvokerAssistant>(
                beanManager, com.example.dbflute.cdi.dbflute.allcommon.ImplementedInvokerAssistant.class, InvokerAssistant.class) {
            @Override
            protected void postInject(final com.example.dbflute.cdi.dbflute.allcommon.ImplementedInvokerAssistant instance) {
                Bean<?> bean = beanManager.resolve(beanManager.getBeans(DataSource.class, createDBFluteAnnotationLiteral()));
                if (bean == null) {
                    bean = beanManager.resolve(beanManager.getBeans(DataSource.class, createDefaultAnnotationLiteral()));
                }
                if (bean == null) {
                    throw new UnsatisfiedResolutionException(String.format(
                            "Unable to resolve a bean for '%s' with qualifiers %s or %s.",
                            DataSource.class.getName(), createDBFluteAnnotationLiteral(), createDefaultAnnotationLiteral()));
                }
                DataSource dataSource = (DataSource) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
                instance.setDataSource(dataSource);
            }
        };
    }

    /**
     * New DBFlute bean for common column auto set-upper.
     * @param beanManager The manager of CDI beans. (NotNull)
     * @return The new-created DBFlute bean. (NotNull)
     */
    protected DBFluteBean<com.example.dbflute.cdi.dbflute.allcommon.ImplementedCommonColumnAutoSetupper> newDBFluteBeanOfCommonColumnAutoSetupper(final BeanManager beanManager) {
        return new DBFluteBean<com.example.dbflute.cdi.dbflute.allcommon.ImplementedCommonColumnAutoSetupper>(beanManager, com.example.dbflute.cdi.dbflute.allcommon.ImplementedCommonColumnAutoSetupper.class, CommonColumnAutoSetupper.class);
    }

    /**
     * New DBFlute bean for behavior selector.
     * @param beanManager The manager of CDI beans. (NotNull)
     * @return The new-created DBFlute bean. (NotNull)
     */
    protected DBFluteBean<ImplementedBehaviorSelector> newDBFluteBeanOfBehaviorSelector(final BeanManager beanManager) {
        return new DBFluteBean<ImplementedBehaviorSelector>(beanManager, ImplementedBehaviorSelector.class, BehaviorSelector.class) {
            @Override
            protected void postInject(final ImplementedBehaviorSelector instance) {
                instance.setContainer(beanManager);
            }
        };
    }

    /**
     * New DBFlute bean for SQL clause creator.
     * @param beanManager The manager of CDI beans. (NotNull)
     * @return The new-created DBFlute bean. (NotNull)
     */
    protected DBFluteBean<ImplementedSqlClauseCreator> newDBFluteBeanOfSqlClauseCreator(final BeanManager beanManager) {
        return new DBFluteBean<ImplementedSqlClauseCreator>(beanManager, ImplementedSqlClauseCreator.class, SqlClauseCreator.class);
    }

    /**
     * New DBFlute bean for behavior command invoker.
     * @param beanManager The manager of CDI beans. (NotNull)
     * @return The new-created DBFlute bean. (NotNull)
     */
    protected DBFluteBean<BehaviorCommandInvoker> newDBFluteBeanOfBehaviorCommandInvoker(final BeanManager beanManager) {
        return new DBFluteBean<BehaviorCommandInvoker>(beanManager, BehaviorCommandInvoker.class) {
            @Override
            protected void postInject(final BehaviorCommandInvoker instance) {
                final Bean<?> bean = beanManager.resolve(beanManager.getBeans(InvokerAssistant.class, createDBFluteAnnotationLiteral()));
                instance.setInvokerAssistant((InvokerAssistant) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)));
            }

            @Override
            public String getName() {
                final StringBuilder name = new StringBuilder(DBFlute.class.getPackage().getName());
                name.append(".");
                name.append(this.beanClass.getSimpleName());
                return name.toString();
            }
        };
    }

    /**
     * Simple implementation of {@link Bean}.
     * @param <T> The type of object.
     */
    public class DBFluteBean<T> implements Bean<T> {
        protected final Class<T> beanClass;
        protected final List<Class<? super T>> superTypes;
        protected final AnnotatedType<T> annotatedType;
        protected final InjectionTarget<T> injectionTarget;

        public DBFluteBean(final BeanManager beanManager, final Class<T> beanClass) {
            this(beanManager, beanClass, (List<Class<? super T>>) null);
        }

        @SuppressWarnings("unchecked")
        public DBFluteBean(final BeanManager beanManager, final Class<T> beanClass, final Class<? super T> superType) {
            this(beanManager, beanClass, new ArrayList<Class<? super T>>(Arrays.asList(superType)));
        }

        public DBFluteBean(final BeanManager beanManager, final Class<T> beanClass, final List<Class<? super T>> superTypes) {
            this.beanClass = beanClass;
            this.superTypes = superTypes;
            this.annotatedType = beanManager.createAnnotatedType(beanClass);
            this.injectionTarget = beanManager.createInjectionTarget(this.annotatedType);
        }

        @Override
        public T create(final CreationalContext<T> creationalContext) {
            final T instance = this.injectionTarget.produce(creationalContext);
            this.injectionTarget.inject(instance, creationalContext);
            this.postInject(instance);
            this.injectionTarget.postConstruct(instance);
            return instance;
        }

        /**
         * Bean customization point.
         * @param instance
         */
        protected void postInject(final T instance) {
        }

        @Override
        public void destroy(final T instance, final CreationalContext<T> creationalContext) {
            this.injectionTarget.preDestroy(instance);
            this.injectionTarget.dispose(instance);
            creationalContext.release();
        };

        @Override
        public Class<?> getBeanClass() {
            return this.beanClass;
        }

        @Override
        public Set<InjectionPoint> getInjectionPoints() {
            return this.injectionTarget.getInjectionPoints();
        }

        @Override
        public String getName() {
            return this.beanClass.getName();
        }

        @Override
        public Set<Annotation> getQualifiers() {
            final Set<Annotation> qualifiers = new HashSet<Annotation>();
            qualifiers.add(createDBFluteAnnotationLiteral());
            qualifiers.add(createDefaultAnnotationLiteral());
            qualifiers.add(createAnyAnnotationLiteral());
            return qualifiers;
        }

        @Override
        public Class<? extends Annotation> getScope() {
            return ApplicationScoped.class;
        }

        @Override
        public Set<Class<? extends Annotation>> getStereotypes() {
            return Collections.emptySet();
        }

        @Override
        public Set<Type> getTypes() {
            final Set<Type> types = new HashSet<Type>();
            types.add(this.beanClass);
            types.add(Object.class);
            if (this.superTypes != null) {
                types.addAll(this.superTypes);
            }
            return types;
        }

        @Override
        public boolean isAlternative() {
            return false;
        }

        @Override
        public boolean isNullable() {
            return false;
        }
    }

    // ===================================================================================
    //                                                                       Behavior Bean
    //                                                                       =============
    /**
     * New behavior-bean instance.
     * @param <BEHAVIOR> The type of behavior.
     * @return Behavior-bean. (NotNull)
     */
    public <BEHAVIOR extends AbstractBehaviorReadable> BehaviorBean<BEHAVIOR> newBehaviorBean(final BeanManager beanManager, final Class<BEHAVIOR> beanClass) {
        return new BehaviorBean<BEHAVIOR>(beanManager, beanClass);
    }

    /**
     * Behavior implementation of {@link Bean}.
     * @param <BEHAVIOR> The type of behavior.
     */
    public class BehaviorBean<BEHAVIOR extends AbstractBehaviorReadable> extends DBFluteBean<BEHAVIOR> {
        protected final BeanManager beanManager;

        public BehaviorBean(final BeanManager beanManager, final Class<BEHAVIOR> beanClass) {
            super(beanManager, beanClass, (List<Class<? super BEHAVIOR>>) null);
            this. beanManager = beanManager;
        }

        @Override
        protected void postInject(final BEHAVIOR instance) {
            Bean<?> bean = beanManager.resolve(beanManager.getBeans(BehaviorCommandInvoker.class, createDBFluteAnnotationLiteral()));
            instance.setBehaviorCommandInvoker((BehaviorCommandInvoker) beanManager.getReference(
                    bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)));

            bean = beanManager.resolve(beanManager.getBeans(BehaviorSelector.class, createDBFluteAnnotationLiteral()));
            instance.setBehaviorSelector((BehaviorSelector) beanManager.getReference(
                    bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)));

            if (instance instanceof AbstractBehaviorWritable) {
                bean = beanManager.resolve(beanManager.getBeans(CommonColumnAutoSetupper.class, createDBFluteAnnotationLiteral()));
                ((AbstractBehaviorWritable) instance).setCommonColumnAutoSetupper(
                        (CommonColumnAutoSetupper) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)));
            }
        }
    }

    // ===================================================================================
    //                                                                  Annotation Literal
    //                                                                  ==================
    /**
     * Create annotation literal for DBFlute.
     * @return The new-created annotation literal. (NotNull)
     */
    protected AnnotationLiteral<DBFlute> createDBFluteAnnotationLiteral() {
        return new AnnotationLiteral<DBFlute>() {
            private static final long serialVersionUID = 1L;
        };
    }

    /**
     * Create annotation literal for default.
     * @return The new-created annotation literal. (NotNull)
     */
    protected AnnotationLiteral<Default> createDefaultAnnotationLiteral() {
        return new AnnotationLiteral<Default>() {
            private static final long serialVersionUID = 1L;
        };
    }

    /**
     * Create annotation literal for any.
     * @return The new-created annotation literal. (NotNull)
     */
    protected AnnotationLiteral<Any> createAnyAnnotationLiteral() {
        return new AnnotationLiteral<Any>() {
            private static final long serialVersionUID = 1L;
        };
    }
}
