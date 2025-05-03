package ApplicationProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = {
        ApplicationProperties.TestApplication.class
})
public class ApplicationProperties {
    @Autowired
    Environment environment;

    @Test
    void testApplicationProperties() {
        String property = environment.getProperty("application.name");
        Integer version = Integer.valueOf(environment.getProperty("application.version"));
        Boolean mode = Boolean.valueOf(environment.getProperty("application.production-mode"));

        Assertions.assertEquals("Belajar spring boot", property);
        Assertions.assertEquals(1, version);
        Assertions.assertEquals(false, mode);
    }

    @SpringBootApplication
    public static class TestApplication{}
}
