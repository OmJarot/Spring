package ConfigurationProperties.Conversion;

import ConfigurationProperties.ConfigurationPropertiesApp;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@SpringBootTest(classes = {
        ConfigurationPropertiesApp.class
})
public class ConversionTest {
    @Autowired
    AppProperties properties;

    @Test
    void testConvert() {
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getTimeOut());
    }

    @Test
    void testConverter() throws ParseException {
        Date expired = properties.getExpired();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Assertions.assertEquals(format.parse("2025-02-01"),expired);
    }
}
