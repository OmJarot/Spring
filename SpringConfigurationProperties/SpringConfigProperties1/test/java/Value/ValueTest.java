package Value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        ApplicationSpring.class
})
public class ValueTest {
    @Autowired
    ApplicationProperties properties;
    @Autowired
    SystemProperties systemProperties;

    @Test
    void testValue() {
        Assertions.assertEquals("Belajar spring boot",properties.getName());
        Assertions.assertEquals(1,properties.getVersion());
        Assertions.assertEquals(false,properties.getProductionMode());
    }

    @Test
    void testSystem() {
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-21",systemProperties.getJava());
    }
}
