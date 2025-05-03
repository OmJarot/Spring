package spring_dasar.Configuration.Bean.PrimaryBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_dasar.Data.Foo;

@Configuration
public class PrimaryConfiguration {

    @Bean
    @Primary//primary, saat bean dipanggi tanpa menyebutkan nama dia akan mengambil bean yang primary
    public Foo foo1(){
        Foo foo = new Foo();
        return foo;
    };

    @Bean
    public Foo foo2(){//untuk mengakses bean yang lain bisa menyebutkan namanya
        Foo foo = new Foo();
        return foo;
    };
}
