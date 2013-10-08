package com.example.dbflute.guice.unit;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

/**
 * The abstract test case for application components of Guice.
 * @author jflute
 * @since 0.9.2 (2009/02/18 Wednesday)
 */
public abstract class GuiceTestCase extends PlainTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          Static Cache
    //                                          ------------
    protected static Injector cachedInjector;

    // -----------------------------------------------------
    //                                          Guice Object
    //                                          ------------
    /** The injector. {Guice Object} */
    protected static Injector injector;

    // -----------------------------------------------------
    //                                Bound Fields(Internal)
    //                                ----------------------
    /** The bound fields. (Internal)*/
    private List<Field> boundFields;

    // ===================================================================================
    //                                                                            Settings
    //                                                                            ========
    /**
     * Set up various components for test.
     */
    @Override
    public void setUp() {
        initializeInjector();
        initializeFields();
        beginTransaction();
    }

    protected void initializeInjector() {
        if (cachedInjector != null) {
            injector = cachedInjector;
            return;
        }
        List<Module> moduleList = new ArrayList<Module>();
        setupApplicationModule(moduleList);
        setupTransactionModule(moduleList);
        injector = Guice.createInjector(moduleList.toArray(new Module[] {}));
        cachedInjector = injector;
    }

    protected abstract void setupApplicationModule(List<Module> moduleList);

    protected abstract void setupTransactionModule(List<Module> moduleList);

    protected void initializeFields() {
        try {
            bindFields();
        } catch (Throwable e) {
            String msg = "bindFields() threw the exception!";
            throw new IllegalStateException(msg, e);
        }
    }

    protected abstract void beginTransaction();

    @Override
    public void tearDown() {
        rollbackTransaction();
        destroyFields();
        destroyInjector();
    }

    protected abstract void rollbackTransaction();

    protected void destroyFields() {
        unbindFields();
    }

    protected void destroyInjector() {
        // Do nothing because of caching!
    }

    // ===================================================================================
    //                                                                       Field Binding
    //                                                                       =============
    protected void bindFields() throws Throwable {
        boundFields = new ArrayList<Field>();
        for (Class<?> clazz = getClass(); isBindTarget(clazz); clazz = clazz.getSuperclass()) {
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; ++i) {
                bindField(fields[i]);
            }
        }
    }

    protected boolean isBindTarget(Class<?> clazz) {
        return clazz != null && clazz != GuiceTestCase.class;
    }

    protected void bindField(Field field) {
        if (!isAutoBindable(field)) {
            return;
        }
        field.setAccessible(true);
        if (getValue(field, this) != null) {
            return;
        }
        Class<?> type = field.getType();
        List<?> bindings = injector.findBindingsByType(TypeLiteral.get(type));
        if (bindings.isEmpty()) {
            return;
        }
        Object component = null;
        try {
            component = injector.getInstance(type);
        } catch (RuntimeException ignored) {
            return;
        }
        if (component != null) {
            setValue(field, this, component);
            boundFields.add(field);
        }
    }

    private Object getValue(Field field, Object target) {
        try {
            return field.get(target);
        } catch (IllegalAccessException e) {
            String msg = "Illegal access to the field: field=" + field + " target=" + target;
            throw new IllegalStateException(msg, e);
        }
    }

    private void setValue(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        } catch (IllegalAccessException e) {
            String msg = "Illegal access to the field: field=" + field + " target=" + target;
            throw new IllegalStateException(msg, e);
        }
    }

    protected String normalizeName(String name) {
        return replaceString(name, "_", "");
    }

    private String replaceString(String text, String fromText, String toText) {
        if (text == null || fromText == null || toText == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int pos2 = 0;
        do {
            pos = text.indexOf(fromText, pos2);
            if (pos == 0) {
                sb.append(toText);
                pos2 = fromText.length();
            } else if (pos > 0) {
                sb.append(text.substring(pos2, pos));
                sb.append(toText);
                pos2 = pos + fromText.length();
            } else {
                sb.append(text.substring(pos2));
                return sb.toString();
            }
        } while (true);
    }

    protected boolean isAutoBindable(Field field) {
        int modifiers = field.getModifiers();
        return !Modifier.isStatic(modifiers) && !Modifier.isFinal(modifiers) && !field.getType().isPrimitive();
    }

    protected boolean isSimpleType(Class<?> type) {
        return String.class.isAssignableFrom(type) || Date.class.isAssignableFrom(type)
                || Number.class.isAssignableFrom(type) || byte[].class.isAssignableFrom(type)
                || Boolean.class.isAssignableFrom(type);
    }

    protected void unbindFields() {
        for (int i = 0; i < boundFields.size(); ++i) {
            Field field = (Field) boundFields.get(i);
            try {
                field.set(this, null);
            } catch (IllegalArgumentException e) {
                System.err.println(e);
            } catch (IllegalAccessException e) {
                System.err.println(e);
            }
        }
        boundFields.clear();
        boundFields = null;
    }

    // ===================================================================================
    //                                                                   Instance Provider
    //                                                                   =================
    protected Object getInstance(Class<?> type) {
        return injector.getInstance(type);
    }

    protected boolean hasInstance(Class<?> type) {
        try {
            injector.getInstance(type);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
