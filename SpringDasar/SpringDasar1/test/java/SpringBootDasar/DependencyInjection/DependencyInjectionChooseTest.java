package SpringBootDasar.DependencyInjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.ChooseDependency.ChooseConfiguration;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

public class DependencyInjectionChooseTest {

    @Test
    void testChoose() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ChooseConfiguration.class);

        Foo primary = context.getBean(Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);
        Bar bar = context.getBean("bar", Bar.class);

        FooBar fooBar = context.getBean(FooBar.class);

        Assertions.assertNotSame(primary,foo2);
        Assertions.assertSame(foo2,fooBar.getFoo());//sama kerena menggunakan foo2
        Assertions.assertSame(bar,fooBar.getBar());
    }
}
