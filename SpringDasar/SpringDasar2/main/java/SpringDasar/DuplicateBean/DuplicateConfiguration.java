package SpringDasar.DuplicateBean;

import Data.Doo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DuplicateConfiguration {

    @Bean
    public Doo boo1(){
        return new Doo();
    }

    @Bean
    public Doo boo2(){
        return new Doo();
    }

}
