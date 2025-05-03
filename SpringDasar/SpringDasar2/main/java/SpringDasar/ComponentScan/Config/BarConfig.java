package SpringDasar.ComponentScan.Config;

import Data.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BarConfig {
    @Bean
    public Bar bar(){
        return new Bar();
    }
}
