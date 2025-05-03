package SpringBootDasar.CustomScope;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.CustomScope.CustomConfiguration;
import spring_dasar.Data.Foo;

public class CustomScopeTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(CustomConfiguration.class);
    }

    @Test
    void testCustom() {
        //hanya membuat 2 object
        Foo foo1 = context.getBean(Foo.class);//membuat bean baru
        Foo foo2 = context.getBean(Foo.class);//membuat bean baru
        Foo foo3 = context.getBean(Foo.class);//mengambil bean foo1
        Foo foo4 = context.getBean(Foo.class);//mengambil bean foo2

        Assertions.assertSame(foo1,foo3);
        Assertions.assertSame(foo2,foo4);
        Assertions.assertNotSame(foo1,foo2);
        Assertions.assertNotSame(foo3,foo4);
    }
}
