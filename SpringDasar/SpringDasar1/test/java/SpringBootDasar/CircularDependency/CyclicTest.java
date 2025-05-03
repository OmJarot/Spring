package SpringBootDasar.CircularDependency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.CircularDependency.CyclicConfiguration;

public class CyclicTest {

    @Test
    void testCyclic() {
        Assertions.assertThrows(Throwable.class,() -> {
            ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
        });
    }
}
