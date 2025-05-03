package SpringDasar.PrimaryBean;

import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {

    @Test
    void testPrimary() {
        ApplicationContext context = new AnnotationConfigApplicationContext(PrimaryConfiguration.class);

        Doo dooPrimary = context.getBean(Doo.class);
        Doo doo1 = context.getBean("boo2", Doo.class);

        Assertions.assertNotSame(dooPrimary, doo1);

    }
}
