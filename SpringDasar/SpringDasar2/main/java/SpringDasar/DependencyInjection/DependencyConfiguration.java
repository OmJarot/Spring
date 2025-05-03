package SpringDasar.DependencyInjection;

import Data.Bar;
import Data.Doo;
import Data.DooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyConfiguration {
    @Bean
    public Doo boo(){
        return new Doo();
    }
    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public DooBar booBar(Doo doo, Bar bar){
        return new DooBar(doo,bar);
    }
}
