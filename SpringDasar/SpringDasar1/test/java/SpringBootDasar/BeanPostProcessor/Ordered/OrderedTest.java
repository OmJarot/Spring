package SpringBootDasar.BeanPostProcessor.Ordered;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.BeanPostProssesor.Car;
import spring_dasar.Configuration.BeanPostProssesor.Ordered.OrderedConfiguration;

public class OrderedTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(OrderedConfiguration.class);
    }

    @Test
    void testOrdered() {
        //urutan BeanPostProcessor
        Car car = context.getBean(Car.class);

        Assertions.assertTrue(car.getId().startsWith("PPG-"));

    }
}
