package SpringConfig;

import SpringConfig.ConfigurationProperties.Converter.StringToDateConverter;
import SpringConfig.ConfigurationProperties.properties.AppProperties;
import org.springframework.boot.SpringApplication;
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
public class SpringBootApp {

    @Bean
    public ConversionService conversionService(StringToDateConverter stringToDateConverter){
        ApplicationConversionService service = new ApplicationConversionService();
        service.addConverter(stringToDateConverter);
        return service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
