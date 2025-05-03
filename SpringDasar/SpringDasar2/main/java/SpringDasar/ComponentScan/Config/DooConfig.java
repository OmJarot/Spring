package SpringDasar.ComponentScan.Config;

import Data.Doo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DooConfig {
    @Bean
    public Doo doo(){
        return new Doo();
    }
}
