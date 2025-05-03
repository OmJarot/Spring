package SpringConfig;

import SpringConfig.Converter.StringToDateConverter;
import SpringConfig.properties.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
        ApplicationProperties.class
})
public class SpringBootConfigApplication {

    @Bean
    public ConversionService conversionService(StringToDateConverter stringToDateConverter){
        ApplicationConversionService service = new ApplicationConversionService();
        service.addConverter(stringToDateConverter);
        return service;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootConfigApplication.class);
    }
}
