package ConfigurationProperties.ComplexConfigurationProperties;

import ConfigurationProperties.ConfigurationPropertiesApp;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        ConfigurationPropertiesApp.class
})
public class EmbeddedTest {
    @Autowired
    AppProperties properties;

    @Test
    void testEmbedded() {
        Assertions.assertEquals("piter",properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", properties.getDatabase().getPassword());
        Assertions.assertEquals("contoh", properties.getDatabase().getUrl());
    }
}
