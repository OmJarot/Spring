package SpringBootDasar.ComponentScan;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Import.MainConfiguration;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;

public class ComponentScanTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(MainConfiguration.class);
    }

    @Test
    void testScan() {

        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);

    }
}
