package SpringDasar.DependencyInjection.Qualifier;

import Data.Bar;
import Data.Doo;
import Data.DooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QualifierConfiguration {

    @Bean(name = "booFirst")
    public Doo boo1(){
        return new Doo();
    }

    @Bean(name = "booSecond")
    public Doo boo2(){
        return new Doo();
    }

    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public DooBar booBar(@Qualifier("booFirst") Doo doo, Bar bar){//jika duplicate bisa menggunakan qualifier untuk menentukan bean yang mana
        return new DooBar(doo,bar);
    }
}
