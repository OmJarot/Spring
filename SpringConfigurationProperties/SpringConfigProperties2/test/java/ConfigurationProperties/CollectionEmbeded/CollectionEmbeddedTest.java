package ConfigurationProperties.CollectionEmbeded;

import ConfigurationProperties.ConfigurationPropertiesApp;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        ConfigurationPropertiesApp.class
})
public class CollectionEmbeddedTest {
    @Autowired
    AppProperties properties;

    @Test
    void testCollectionEmbedded() {
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("default role", properties.getDefaultRoles().get(0).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("admin role", properties.getRoles().get("admin").getName());
    }
}
