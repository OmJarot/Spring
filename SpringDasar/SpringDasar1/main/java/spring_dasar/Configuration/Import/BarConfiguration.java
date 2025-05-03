package spring_dasar.Configuration.Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.Bar;

@Configuration
public class BarConfiguration {

    @Bean
    public Bar bar(){
        return new Bar();
    }

}
