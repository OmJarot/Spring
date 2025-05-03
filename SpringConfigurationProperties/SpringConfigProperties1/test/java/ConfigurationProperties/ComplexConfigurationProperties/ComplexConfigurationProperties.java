package ConfigurationProperties.ComplexConfigurationProperties;

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
public class ComplexConfigurationProperties {
    @Autowired
    ApplicationProperties properties;

    @Test
    void testComplex() {
        Assertions.assertEquals("piter", properties.getDatabase().getUsername());
        Assertions.assertEquals("rahasia", properties.getDatabase().getPassword());
        Assertions.assertEquals("belajar", properties.getDatabase().getDatabase());
        Assertions.assertEquals("jdbc:contoh", properties.getDatabase().getUrl());
    }

//    @SpringBootApplication
//    @EnableConfigurationProperties({//memberitahu spring boot untuk enable configuration SpringConfig.properties
//            SpringConfig.properties.ApplicationProperties.class//otomatis dijadikan bean
//    })
//    public static class TestApplications{
//
//    }
}
