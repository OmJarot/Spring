package Environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = {
        EnvironmentConfig.class
})
public class EnvironmentTest {
    //membaca SpringConfig.properties environment dari sistem operasi
    @Autowired
    Environment environment;

    @Test
    void testEnvironment() {
        String java = environment.getProperty("JAVA_HOME");
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-21", java);
    }

    @Autowired
    EnvAware envAware;
    @Test
    void testEnvironmentAware() {
        String java = envAware.getEnv("JAVA_HOME");
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-21", java);
    }
}
