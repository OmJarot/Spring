package SpringDasar.CyclicDependency;

import SpringDasar.DependencyInjection.Cyclic.CyclicConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CyclicDependencyTest {

    @Test
    void testCyclic() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
    }
}
