package SpringDasar.PrimaryBean;

import Data.Doo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryConfiguration {

    @Bean
    @Primary
    public Doo boo1(){
        return new Doo();
    }

    @Bean
    public Doo boo2(){
        return new Doo();
    }
}
