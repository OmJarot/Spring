package SpringDasar.DepenOn;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DependOnTest {
    @Test
    void testDepenOn() {

        ApplicationContext context = new AnnotationConfigApplicationContext(DependOnConfiguration.class);

    }
}
