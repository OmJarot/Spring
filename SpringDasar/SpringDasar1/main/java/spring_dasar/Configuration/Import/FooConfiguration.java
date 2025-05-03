package spring_dasar.Configuration.Import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.Foo;

@Configuration
public class FooConfiguration {

    @Bean
    public Foo foo(){
        return new Foo();
    }

}
