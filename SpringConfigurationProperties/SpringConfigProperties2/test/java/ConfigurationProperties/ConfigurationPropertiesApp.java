package ConfigurationProperties;

import SpringConfig.ConfigurationProperties.Converter.StringToDateConverter;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
        AppProperties.class
})
@Import(StringToDateConverter.class)
public class ConfigurationPropertiesApp {
    @Bean
    public ConversionService conversionService(StringToDateConverter stringToDateConverter){
        ApplicationConversionService service = new ApplicationConversionService();
        service.addConverter(stringToDateConverter);
        return service;
    }

}
