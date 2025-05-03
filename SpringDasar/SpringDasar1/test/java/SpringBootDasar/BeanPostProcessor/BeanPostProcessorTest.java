package SpringBootDasar.BeanPostProcessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.BeanPostProssesor.BeanPostProcessorConfig;
import spring_dasar.Configuration.BeanPostProssesor.Car;

public class BeanPostProcessorTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(BeanPostProcessorConfig.class);
    }

    @Test
    void testBean() {
        Car car = context.getBean(Car.class);
        Assertions.assertNotNull(car.getId());//tidak null karena id otomatis di isi
    }
}
