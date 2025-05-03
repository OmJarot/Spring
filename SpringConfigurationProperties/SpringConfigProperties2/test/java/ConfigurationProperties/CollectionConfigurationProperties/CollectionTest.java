package ConfigurationProperties.CollectionConfigurationProperties;

import ConfigurationProperties.ConfigurationPropertiesApp;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {
        ConfigurationPropertiesApp.class
})
public class CollectionTest {

    @Autowired
    AppProperties properties;

    @Test
    void testCollection() {
        Assertions.assertEquals(Arrays.asList("customer", "production", "dll"), properties.getDatabase().getWhitelistTables());

        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("customer"));
        Assertions.assertEquals(200, properties.getDatabase().getMaxTablesSize().get("production"));
        Assertions.assertEquals(300, properties.getDatabase().getMaxTablesSize().get("dll"));
    }
}
