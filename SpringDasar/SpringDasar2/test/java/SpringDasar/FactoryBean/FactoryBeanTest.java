package SpringDasar.FactoryBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {
    @Test
    void testFactoryBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(GovernmentConfig.class);
        Government government = context.getBean(Government.class);

        Assertions.assertEquals("a", government.getA());
        Assertions.assertEquals("b", government.getB());
        Assertions.assertEquals("c", government.getC());
    }
}
