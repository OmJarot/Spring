package SpringDasar.ObjectProvider;

import Data.Doo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

@Configuration
@Import({
        MultiDoo.class
})
public class ObjectProviderConfig {
    @Bean
    @Primary
    public Doo doo1(){
        return new Doo();
    }

    @Bean
    public Doo doo2(){
        return new Doo();
    }

    @Bean
    public Doo doo3(){
        return new Doo();
    }

}
