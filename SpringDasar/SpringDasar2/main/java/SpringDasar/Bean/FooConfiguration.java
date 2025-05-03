package SpringDasar.Bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class FooConfiguration {

    @Bean
    public Foo foo(){
        log.info("Created new Foo");
        return new Foo();
    }

}
