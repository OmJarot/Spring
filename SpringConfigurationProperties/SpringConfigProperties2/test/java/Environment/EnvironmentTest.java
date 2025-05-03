package Environment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        EnvironmentApplication.class
})
public class EnvironmentTest {

    @Autowired
    EnvironmentApplication.SampleEnv env;

    @Test
    void testEnvironment() {
        String name = env.getEnv("application.name");

        Assertions.assertEquals("Belajar spring boot", name);
    }
}
