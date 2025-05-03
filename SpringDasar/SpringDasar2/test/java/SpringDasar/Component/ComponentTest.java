package SpringDasar.Component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    @Test
    void testComponent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        See see = context.getBean(See.class);

        Assertions.assertNotNull(see);
    }
}
