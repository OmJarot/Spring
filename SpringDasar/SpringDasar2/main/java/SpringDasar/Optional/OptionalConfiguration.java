package SpringDasar.Optional;

import Data.Bar;
import Data.Doo;
import Data.DooBar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class OptionalConfiguration {
    @Bean
    public Bar bar(){
        return new Bar();
    }

    @Bean
    public DooBar dooBar(Optional<Doo> doo,  Optional<Bar> bar){
        return new DooBar(doo.orElse(null), bar.orElse(null));//jika tidak ada bean doo maka akan null
    }

}
