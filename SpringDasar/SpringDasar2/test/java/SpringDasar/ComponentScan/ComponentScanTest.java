package SpringDasar.ComponentScan;

import Data.Bar;
import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentScanTest {

    @Test
    void testComponentScan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfig.class);

        Doo doo = context.getBean(Doo.class);
        Bar bar = context.getBean(Bar.class);

        Assertions.assertNotNull(doo);
        Assertions.assertNotNull(bar);
    }
}
