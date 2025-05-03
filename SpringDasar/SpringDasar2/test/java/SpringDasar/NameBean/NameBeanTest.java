package SpringDasar.NameBean;

import Data.Doo;
import SpringDasar.BeanName.NameConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class NameBeanTest {

    @Test
    void testName() {
        ApplicationContext context = new AnnotationConfigApplicationContext(NameConfiguration.class);

        Doo dooFirst = context.getBean("booFirst", Doo.class);
        Doo dooSecond = context.getBean("booSecond", Doo.class);

        Assertions.assertNotSame(dooFirst, dooSecond);
    }
}
