package spring_dasar.Configuration.BeanPostProssesor.Ordered;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring_dasar.Configuration.BeanPostProssesor.Car;
import spring_dasar.Configuration.BeanPostProssesor.IdGeneratorBeanPostProcessor;

@Configuration
@Import({
        OrderedBeanPostProcessor.class,
        Car.class,
        IdGeneratorBeanPostProcessor.class
})
public class OrderedConfiguration {
}
