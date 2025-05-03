package SpringDasar.BeanPostProcessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanPostProcessorTest {
    @Test
    void testBeanPostProcessor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
        Car car = context.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        System.out.println(car.getId());
    }
}
