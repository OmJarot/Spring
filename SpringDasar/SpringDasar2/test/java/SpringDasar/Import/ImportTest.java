package SpringDasar.Import;

import Data.Bar;
import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {

    @Test
    void testImport() {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Bar bar = context.getBean(Bar.class);
        Doo bean = context.getBean(Doo.class);

        Assertions.assertNotNull(bar);
        Assertions.assertNotNull(bean);
    }
}
