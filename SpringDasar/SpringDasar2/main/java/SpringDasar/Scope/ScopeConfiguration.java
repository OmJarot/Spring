package SpringDasar.Scope;

import Data.Doo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Slf4j
public class ScopeConfiguration {

    @Bean
    @Scope("prototype")//akan di buat membuat object baru setiap get bean
    public Doo boo(){
        log.info("Crated new Boo");
        return new Doo();
    }
}
