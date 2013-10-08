package com.example.dbflute.guice.dbflute.whitebox.container;

import java.util.List;

import org.seasar.dbflute.cbean.ConditionBean;

import com.example.dbflute.guice.unit.PlainTestCase;
import com.google.inject.AbstractModule;
import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.TypeLiteral;

public class WxGuiceTest extends PlainTestCase {

    public void test_bind_Interface_to_Implementation() {
        // ## Arrange ##
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Foo.class).to(FooImpl.class);
            }
        });

        // ## Act ##
        Foo instance = injector.getInstance(Foo.class);

        // ## Assert ##
        log("instance=[" + instance + "]");
        assertNotNull(instance);
        assertTrue(instance instanceof FooImpl);
    }

    public void test_bind_Interface_toInstance_Implementation() {
        // ## Arrange ##
        final FooImpl impl = new FooImpl();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Foo.class).toInstance(impl);
            }
        });

        // ## Act ##
        Foo instance = injector.getInstance(Foo.class);

        // ## Assert ##
        log("instance=[" + instance + "]");
        assertNotNull(instance);
        assertTrue(instance instanceof FooImpl);
        assertEquals(impl, instance);
    }

    public void test_bind_Implementation_to_Implementation() {
        // ## Arrange ##
        try {
            // ## Act ##
            Guice.createInjector(new AbstractModule() {
                @Override
                protected void configure() {
                    bind(FooImpl.class).to(FooImpl.class);
                }
            });

            // ## Assert ##
            fail();
        } catch (RuntimeException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_bind_Implementation_toInstance_Implementation() {
        // ## Arrange ##
        final Bar impl = new Bar();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Foo.class).to(FooImpl.class);
                bind(Bar.class).toInstance(impl);
            }
        });

        // ## Act ##
        Bar instance = injector.getInstance(Bar.class);

        // ## Assert ##
        log("instance=[" + instance + "]");
        assertNotNull(instance);
        assertEquals(impl, instance);
        assertNotNull(instance.getFoo());
        assertTrue(instance.getFoo() instanceof FooImpl);
    }

    public void test_getInstance_client() {
        // ## Arrange ##
        final Bar impl = new Bar();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Foo.class).to(FooImpl.class);
                bind(Bar.class).toInstance(impl);
            }
        });

        // ## Act ##
        Client instance = injector.getInstance(Client.class);

        // ## Assert ##
        log("instance=[" + instance + "]");
        assertNotNull(instance);
        assertNotNull(instance.getFoo());
        assertNotNull(instance.getBar());
        Client anotherInstance = injector.getInstance(Client.class);
        assertNotNull(anotherInstance.getFoo());
        assertNotNull(anotherInstance.getBar());
        assertNotSame(instance, anotherInstance);
        Client anotherInstanceNext = injector.getInstance(Client.class);
        assertNotSame(anotherInstance, anotherInstanceNext);
        log(instance);
        log(anotherInstance);
        log(anotherInstanceNext);
    }

    public void test_injectMembers_client() {
        // ## Arrange ##
        final Bar impl = new Bar();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Foo.class).to(FooImpl.class);
                bind(Bar.class).toInstance(impl);
            }
        });
        Client instance = new Client();

        // ## Act ##
        injector.injectMembers(instance);

        // ## Assert ##
        log("instance=[" + instance + "]");
        assertNotNull(instance);
        assertNotNull(instance.getFoo());
        assertNotNull(instance.getBar());
        Client anotherInstance = injector.getInstance(Client.class);
        assertNotNull(anotherInstance.getFoo());
        assertNotNull(anotherInstance.getBar());
        assertNotSame(instance, anotherInstance);
        Client anotherInstanceNext = injector.getInstance(Client.class);
        assertNotSame(anotherInstance, anotherInstanceNext);
        log(instance);
        log(anotherInstance);
        log(anotherInstanceNext);
    }

    public void test_findBindingsByType() {
        // ## Arrange ##
        final Bar impl = new Bar();
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Foo.class).to(FooImpl.class);
                bind(Bar.class).toInstance(impl);
            }
        });

        // ## Act ##
        List<Binding<Foo>> fooList = injector.findBindingsByType(TypeLiteral.get(Foo.class));
        List<Binding<Bar>> barList = injector.findBindingsByType(TypeLiteral.get(Bar.class));
        List<Binding<Client>> clientList = injector.findBindingsByType(TypeLiteral.get(Client.class));

        // ## Assert ##
        assertEquals(1, fooList.size());
        assertEquals(1, barList.size());
        assertEquals(0, clientList.size());
    }

    public static interface Foo {
        void execute();
    }

    public static class FooImpl implements Foo {
        public void execute() {
        }
    }

    public static class Bar {
        private Foo foo;

        public Foo getFoo() {
            return foo;
        }

        @Inject
        public void setFoo(Foo foo) {
            this.foo = foo;
        }
    }

    public static class Client {
        private Foo foo;
        private Bar bar;

        public Foo getFoo() {
            return foo;
        }

        public Bar getBar() {
            return bar;
        }

        @Inject
        public void setFooAndBar(Foo foo, Bar bar) {
            this.foo = foo;
            this.bar = bar;
        }
    }

    public void test_Injector_getInstance_String() {
        // ## Arrange ##
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
            }
        });

        // ## Act ##
        String instance = injector.getInstance(String.class);

        // ## Assert ##
        log("[String.class]");
        log("instance=[" + instance + "]");
        assertNotNull(instance);
        log("type=[" + instance.getClass() + "]");
    }

    public void test_Injector_getInstance_Interface() {
        // ## Arrange ##
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
            }
        });

        // ## Act & Assert ##
        try {
            injector.getInstance(ConditionBean.class);
            fail();
        } catch (RuntimeException e) {
            // OK
            log(e.getMessage());
        }
    }
}
