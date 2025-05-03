package ConfigurationProperties.CollectionEmbeddedConfigurationProperties;

import ConfigurationProperties.TestApplications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import SpringConfig.properties.ApplicationProperties;
@SpringBootTest(classes = {
        TestApplications.class
})
public class CollectionEmbeddedTest {

    @Autowired
    ApplicationProperties properties;

    @Test
    void testEmbeddedCollection() {
        Assertions.assertEquals("default", properties.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("default role", properties.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", properties.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("guest role", properties.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", properties.getRoles().get("admin").getId());
        Assertions.assertEquals("admin role", properties.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", properties.getRoles().get("finance").getId());
        Assertions.assertEquals("finance role", properties.getRoles().get("finance").getName());
    }

//    @SpringBootApplication
//    @EnableConfigurationProperties({//memberitahu spring boot untuk enable configuration SpringConfig.properties
//            SpringConfig.properties.ApplicationProperties.class//otomatis dijadikan bean
//    })
//    public static class TestCollection{
//
//    }
}
