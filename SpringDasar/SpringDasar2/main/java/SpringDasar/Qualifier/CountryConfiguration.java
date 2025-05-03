package SpringDasar.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfiguration {

    @Bean
    public CountryRepository countryRepository1(){
        return new CountryRepository();
    }

    @Bean
    public CountryRepository countryRepository2(){
        return new CountryRepository();
    }

}
