package spring_dasar.Configuration.Optional.ObjectProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import spring_dasar.Data.Foo;

@Configuration
@Import(ObjectProviderFoo.class)
public class ObjectConfiguration {

    @Bean
    @Primary
    public Foo foo1(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }

    @Bean
    public Foo foo3(){
        return new Foo();
    }


}
