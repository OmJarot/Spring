package ConfigurationProperties;

import SpringConfig.Converter.StringToDateConverter;
import SpringConfig.properties.ApplicationProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({//memberitahu spring boot untuk enable configuration SpringConfig.properties
        ApplicationProperties.class//otomatis dijadikan bean
})
@Import(StringToDateConverter.class)
public class TestApplications {

    @Bean
    //registrasi converter yang telah kita buat
    public ConversionService conversionService(StringToDateConverter stringToDateConverter){
        ApplicationConversionService conversionService = new ApplicationConversionService();
        conversionService.addConverter(stringToDateConverter);
        return conversionService;
    }

}
