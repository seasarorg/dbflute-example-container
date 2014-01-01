/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.allcommon;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.enterprise.util.AnnotationLiteral;

import org.seasar.dbflute.BehaviorSelector;
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

    /**
     * Register DBFlute beans to container.
     * @param event event
     * @param beanManager bean manager
     */
    public void afterBeanDiscovery(@Observes final AfterBeanDiscovery event, final BeanManager beanManager) {
        this.setupDfComponents(event, beanManager);
        this.setupBehaviors(event, beanManager);
    }

    /**
     * Register environment dependent implementations to container.
     * @param event
     * @param beanManager
     */
    @SuppressWarnings("unchecked")
    protected void setupDfComponents(final AfterBeanDiscovery event, final BeanManager beanManager) {
        event.addBean(new DBFluteBean<com.example.dbflute.cdi.dbflute.allcommon.ImplementedInvokerAssistant>(beanManager, com.example.dbflute.cdi.dbflute.allcommon.ImplementedInvokerAssistant.class, InvokerAssistant.class));
        event.addBean(new DBFluteBean<com.example.dbflute.cdi.dbflute.allcommon.ImplementedCommonColumnAutoSetupper>(beanManager, com.example.dbflute.cdi.dbflute.allcommon.ImplementedCommonColumnAutoSetupper.class, CommonColumnAutoSetupper.class));
        event.addBean(new DBFluteBean<ImplementedBehaviorSelector>(beanManager, ImplementedBehaviorSelector.class, BehaviorSelector.class));
        event.addBean(new DBFluteBean<ImplementedSqlClauseCreator>(beanManager, ImplementedSqlClauseCreator.class, SqlClauseCreator.class));

        event.addBean(new DBFluteBean<BehaviorCommandInvoker>(beanManager, BehaviorCommandInvoker.class) {
            @SuppressWarnings("serial")
            @Override
            protected void postInject(final BehaviorCommandInvoker instance) {
                final Bean<?> iaBean = beanManager.resolve(beanManager.getBeans(
                        InvokerAssistant.class, new AnnotationLiteral<Default>() {}));
                instance.setInvokerAssistant((InvokerAssistant) beanManager.getReference(
                        iaBean, iaBean.getBeanClass(), beanManager.createCreationalContext(iaBean)));
            }
        });
    }

    /**
     * Register behaviors to container.
     * @param event
     * @param beanManager
     */
    protected void setupBehaviors(final AfterBeanDiscovery event, final BeanManager beanManager) {
        event.addBean(new DBFluteBean<MemberBhv>(beanManager, MemberBhv.class));
        event.addBean(new DBFluteBean<MemberAddressBhv>(beanManager, MemberAddressBhv.class));
        event.addBean(new DBFluteBean<MemberLoginBhv>(beanManager, MemberLoginBhv.class));
        event.addBean(new DBFluteBean<MemberSecurityBhv>(beanManager, MemberSecurityBhv.class));
        event.addBean(new DBFluteBean<MemberServiceBhv>(beanManager, MemberServiceBhv.class));
        event.addBean(new DBFluteBean<MemberStatusBhv>(beanManager, MemberStatusBhv.class));
        event.addBean(new DBFluteBean<MemberWithdrawalBhv>(beanManager, MemberWithdrawalBhv.class));
        event.addBean(new DBFluteBean<ProductBhv>(beanManager, ProductBhv.class));
        event.addBean(new DBFluteBean<ProductCategoryBhv>(beanManager, ProductCategoryBhv.class));
        event.addBean(new DBFluteBean<ProductStatusBhv>(beanManager, ProductStatusBhv.class));
        event.addBean(new DBFluteBean<PurchaseBhv>(beanManager, PurchaseBhv.class));
        event.addBean(new DBFluteBean<RegionBhv>(beanManager, RegionBhv.class));
        event.addBean(new DBFluteBean<ServiceRankBhv>(beanManager, ServiceRankBhv.class));
        event.addBean(new DBFluteBean<SummaryProductBhv>(beanManager, SummaryProductBhv.class));
        event.addBean(new DBFluteBean<SummaryWithdrawalBhv>(beanManager, SummaryWithdrawalBhv.class));
        event.addBean(new DBFluteBean<VendorCheckBhv>(beanManager, VendorCheckBhv.class));
        event.addBean(new DBFluteBean<WithdrawalReasonBhv>(beanManager, WithdrawalReasonBhv.class));
    }

    /**
     * Initialize DBFlute.
     * @param event
     */
    public void afterDeploymentValidation(@Observes final AfterDeploymentValidation event) {
        new com.example.dbflute.cdi.dbflute.allcommon.DBFluteInitializer();
    }

    /**
     * Simple implementation of {@link Bean}.
     *
     * @param <T>
     */
    public class DBFluteBean<T> implements Bean<T> {
        private final Class<T> beanClass;
        private final Class<? super T>[] superTypes;
        private final AnnotatedType<T> at;
        private final InjectionTarget<T> it;

        public DBFluteBean(final BeanManager beanManager, final Class<T> beanClass, final Class<? super T>... superTypes) {
            this.beanClass = beanClass;
            this.superTypes = superTypes;
            this.at = beanManager.createAnnotatedType(beanClass);
            this.it = beanManager.createInjectionTarget(this.at);
        }

        @Override
        public T create(final CreationalContext<T> cc) {
            final T instance = this.it.produce(cc);
            this.it.inject(instance, cc);
            this.postInject(instance);
            this.it.postConstruct(instance);
            return instance;
        }

        /**
         * Bean customization point.
         * @param instance
         */
        protected void postInject(final T instance) {
        }

        @Override
        public void destroy(final T instance, final CreationalContext<T> cc) {
            this.it.preDestroy(instance);
            this.it.dispose(instance);
            cc.release();
        };

        @Override
        public Class<?> getBeanClass() {
            return this.beanClass;
        }

        @Override
        public Set<InjectionPoint> getInjectionPoints() {
            return this.it.getInjectionPoints();
        }

        @Override
        public String getName() {
            String className = this.beanClass.getName();
            final int index = className.lastIndexOf('.');
            if (0 < index) {
                className = className.substring(index + 1);
            }
            final char[] chars = className.toCharArray();
            if (Character.isUpperCase(chars[0])) {
                chars[0] = Character.toLowerCase(chars[0]);
            }
            return new String(chars);
        }

        @Override
        @SuppressWarnings("serial")
        public Set<Annotation> getQualifiers() {
            final Set<Annotation> qualifiers = new HashSet<Annotation>();
            qualifiers.add(new AnnotationLiteral<Default>() {});
            qualifiers.add(new AnnotationLiteral<Any>() {});
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
                types.addAll(Arrays.asList(this.superTypes));
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
}
