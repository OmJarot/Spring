package SpringDasar.BeanName;

import Data.Doo;
import org.springframework.context.annotation.Bean;

public class NameConfiguration {
    //default menggunakan nama method

    @Bean(name = "booFirst")
    public Doo boo1(){
        return new Doo();
    }

    @Bean(name = "booSecond")
    public Doo boo2(){
        return new Doo();
    }
}
