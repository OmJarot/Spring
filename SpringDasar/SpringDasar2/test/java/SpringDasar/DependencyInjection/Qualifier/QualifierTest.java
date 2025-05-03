package SpringDasar.DependencyInjection.Qualifier;

import Data.Bar;
import Data.Doo;
import Data.DooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class QualifierTest {

    @Test
    void testQualifier() {
        ApplicationContext context  = new AnnotationConfigApplicationContext(QualifierConfiguration.class);

        Doo dooFirst = context.getBean("booFirst", Doo.class);
        Doo dooSecond = context.getBean("booSecond", Doo.class);
        Bar bar = context.getBean(Bar.class);

        DooBar dooBar = context.getBean(DooBar.class);

        Assertions.assertNotSame(dooFirst, dooSecond);
        Assertions.assertSame(dooFirst, dooBar.getDoo());
        Assertions.assertSame(bar, dooBar.getBar());
    }
}
