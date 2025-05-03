package SpringDasar.Lazy;

import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyTest {

    @Test
    void testLazy() throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(LazyConfiguration.class);
        Thread.sleep(2000L);
        Doo doo = context.getBean(Doo.class);
        Assertions.assertNotNull(doo);
    }
}
