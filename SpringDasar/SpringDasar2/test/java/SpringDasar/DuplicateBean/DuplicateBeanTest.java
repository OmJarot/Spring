package SpringDasar.DuplicateBean;

import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DuplicateBeanTest {

    @Test
    void testDuplicate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DuplicateConfiguration.class);

        Doo doo1 = context.getBean("boo1", Doo.class);
        Doo doo2 = context.getBean("boo2", Doo.class);

        Assertions.assertNotSame(doo1, doo2);
    }
}
