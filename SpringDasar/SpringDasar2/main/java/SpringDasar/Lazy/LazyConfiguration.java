package SpringDasar.Lazy;

import Data.Bar;
import Data.Doo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@Slf4j
public class LazyConfiguration {

    @Lazy
    @Bean
    public Doo boo(){
        log.info("Crated new Boo");
        return new Doo();
    }

    @Bean
    public Bar bar(){
        log.info("Crated new Bar");
        return new Bar();
    }
}
