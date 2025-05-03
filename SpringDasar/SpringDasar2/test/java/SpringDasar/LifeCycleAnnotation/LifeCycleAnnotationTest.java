package SpringDasar.LifeCycleAnnotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleAnnotationTest {
    @Test
    void testAnnotation() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
//        context.close();
        context.registerShutdownHook();
    }
}
