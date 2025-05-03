package SpringDasar.LifeCycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {
    @Test
    void testLifecycle() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
//        context.close();
        context.registerShutdownHook();
    }
}
