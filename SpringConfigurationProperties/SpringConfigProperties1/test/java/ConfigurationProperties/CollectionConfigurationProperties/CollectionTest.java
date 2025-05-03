package ConfigurationProperties.CollectionConfigurationProperties;

import ConfigurationProperties.TestApplications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import SpringConfig.properties.ApplicationProperties;

import java.util.Arrays;

@SpringBootTest(classes = {
        TestApplications.class
})
public class CollectionTest {
    @Autowired
    ApplicationProperties properties;

    @Test
    void testCollection() {
        Assertions.assertEquals(Arrays.asList("product", "customer", "categories"), properties.getDatabase().getWhitelistTables());
        Assertions.assertEquals(100, properties.getDatabase().getMaxTablesSize().get("product"));
        Assertions.assertEquals(300, properties.getDatabase().getMaxTablesSize().get("customer"));
        Assertions.assertEquals(200, properties.getDatabase().getMaxTablesSize().get("categories"));
    }

//    @SpringBootApplication
//    @EnableConfigurationProperties({//memberitahu spring boot untuk enable configuration SpringConfig.properties
//            SpringConfig.properties.ApplicationProperties.class//otomatis dijadikan bean
//    })
//    public static class TestCollection{
//
//    }
}
