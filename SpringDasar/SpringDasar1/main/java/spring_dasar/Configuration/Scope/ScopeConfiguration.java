package spring_dasar.Configuration.Scope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spring_dasar.Data.Foo;

@Slf4j
@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("prototype")//set scope, bean Selalu dibuat object baru setiap kali bean diakses
    public Foo foo(){
        log.info("Create new Foo");
        return new Foo();
    }

//    singleton(Default) : Hanya dibuat sekali dalam Spring IoC
//    prototype : Selalu dibuat object baru setiap kali bean diakses
//    request : Dibuat baru per HTTP Request (hanya untuk Web App)
//    session : Dibuat baru per HTTP Session (hanya untuk Web App)
//    application : Dibuat baru per ServletContext (hanya untuk Web App)
//    websocket : Dibuat baru per WebSocket (hanya untuk WebSocket App)


}
