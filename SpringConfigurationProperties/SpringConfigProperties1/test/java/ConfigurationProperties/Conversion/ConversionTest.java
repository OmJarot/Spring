package ConfigurationProperties.Conversion;

import ConfigurationProperties.TestApplications;
import SpringConfig.Converter.StringToDateConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import SpringConfig.properties.ApplicationProperties;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

@SpringBootTest(classes = {
        TestApplications.class
})
public class ConversionTest {

    @Autowired
    ApplicationProperties properties;

    @Test
    void testConversion() {
        Assertions.assertEquals(Duration.ofSeconds(10), properties.getTimeOut());
    }

    @Test
    void testConversionCustome() {
        Date date = properties.getExpireDate();
        var dateFormater = new SimpleDateFormat("yyy-MM-dd");

//        Assertions.assertEquals("2025-10-01", dateFormater.format(date));
    }

//    @SpringBootApplication
//    @EnableConfigurationProperties({//memberitahu spring boot untuk enable configuration SpringConfig.properties
//            SpringConfig.properties.ApplicationProperties.class//otomatis dijadikan bean
//    })
//    @Import(StringToDateConverter.class)
//    public static class TestConversion{
//
//        @Bean
//        //registrasi converter yang telah kita buat
//        public ConversionService conversionService(StringToDateConverter stringToDateConverter){
//            ApplicationConversionService conversionService = new ApplicationConversionService();
//            conversionService.addConverter(stringToDateConverter);
//            return conversionService;
//        }
//
//    }

    //atau bisa menggunakan ConversionService secara langsung
    @Autowired
    ConversionService conversionService;

    @Test
    void testConversionService() {
        Assertions.assertTrue(conversionService.canConvert(String.class, Duration.class));
        Assertions.assertTrue(conversionService.canConvert(String.class, Date.class));

        Integer convert = conversionService.convert("2", Integer.class);
        System.out.println(convert);
    }
}
