package SpringBootDasar.DependencyInjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.DependencyInjetion.DependencyConfiguration;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

public class DependencyInjectionTest {

    @Test
    void testNoDI() {//tanpa dependency injection
        Foo foo = new Foo();
        Bar bar = new Bar();

        FooBar fooBar = new FooBar(foo, bar);

        Assertions.assertEquals(foo, fooBar.getFoo());
        Assertions.assertEquals(bar, fooBar.getBar());
    }

    @Test
    void testDependencyInjection() {
        //menggunakan dependency injection
        ApplicationContext context = new AnnotationConfigApplicationContext(DependencyConfiguration.class);

        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);
        FooBar fooBar = context.getBean(FooBar.class);//otomatis mencarikan bean/object yang sesuai dengan parameternya

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
