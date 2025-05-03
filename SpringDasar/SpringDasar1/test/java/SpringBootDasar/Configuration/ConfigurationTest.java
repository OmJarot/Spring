package SpringBootDasar.Configuration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.HelloWorldConfiguration;

public class ConfigurationTest {

    @Test
    void testConfiguration() {
        //membuat aplication context menggunakan configuration
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        Assertions.assertNotNull(context);
    }
}
