package SpringBootDasar.Import;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Import.MainConfiguration;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;

public class ImportTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(MainConfiguration.class);
    }

    @Test
    void testImport() {

        Foo foo = context.getBean(Foo.class);
        Bar bar = context.getBean(Bar.class);

    }

}
