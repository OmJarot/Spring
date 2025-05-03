package spring_dasar.Configuration.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

import java.util.Optional;

@Configuration
public class OptionalConfiguration {

    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public FooBar fooBar(Optional<Foo> foo,  Optional<Bar> bar){//optional jika beannya tidak ada maka mengembalikan null, tidak akan error
        return new FooBar(foo.orElse(null), bar.orElse(null));//bar akan null karena tidak ada bean bar
    }

}
