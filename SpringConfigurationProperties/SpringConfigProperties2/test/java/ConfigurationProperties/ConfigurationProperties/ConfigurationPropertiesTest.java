package ConfigurationProperties.ConfigurationProperties;

import ConfigurationProperties.ConfigurationPropertiesApp;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        ConfigurationPropertiesApp.class
})
public class ConfigurationPropertiesTest {

    @Autowired
    AppProperties properties;

    @Test
    void testProperties() {
        Assertions.assertEquals("Belajar spring boot", properties.getName());
        Assertions.assertEquals(1, properties.getVersion());
        Assertions.assertEquals(false, properties.getProductionMode());
    }
}
