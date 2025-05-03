package SpringDasar.DependencyInjection;

import Data.Bar;
import Data.Doo;
import Data.DooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependencyTest {
    @Test
    void testDependency() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DependencyConfiguration.class);;

        DooBar dooBar = context.getBean(DooBar.class);
        Doo doo = context.getBean(Doo.class);
        Bar bar = context.getBean(Bar.class);

        Assertions.assertSame(doo, dooBar.getDoo());
        Assertions.assertSame(bar, dooBar.getBar());
    }
}
