package ConfigurationProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import SpringConfig.properties.ApplicationProperties;

@SpringBootTest(classes = {
        TestApplications.class
})
public class ConfigurationPropertiesTest {

    @Autowired
    ApplicationProperties properties;

    @Test
    void testConfigurationProperties() {
        Assertions.assertEquals("Belajar spring boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.getProductionMode());
    }

//    @SpringBootApplication
//    @EnableConfigurationProperties({//memberitahu spring boot untuk enable configuration SpringConfig.properties
//            ApplicationProperties.class//otomatis dijadikan bean
//    })
//    public static class TestApplication{
//
//    }

}
