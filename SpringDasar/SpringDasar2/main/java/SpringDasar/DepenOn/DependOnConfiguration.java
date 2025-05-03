package SpringDasar.DepenOn;

import Data.Bar;
import Data.Doo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Slf4j
@Configuration
public class DependOnConfiguration {

    @Bean
    @DependsOn(value = "bar")
    public Doo boo(){//akan dibuat setelah bar dibuat
        log.info("Crated new Boo");
        return new Doo();
    }

    @Bean
    public Bar bar(){
        log.info("Crated new Bar");
        return new Bar();
    }
}
