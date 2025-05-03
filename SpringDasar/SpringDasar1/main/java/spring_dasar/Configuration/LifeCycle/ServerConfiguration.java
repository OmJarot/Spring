package spring_dasar.Configuration.LifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.LifeCycle.Server;

@Configuration
public class ServerConfiguration {

    @Bean(initMethod = "start",destroyMethod = "stop")//akan menjalankan method start saat bean telah siap, dan akan menjalankan method stop saat aplikasi shutdown
    public Server server(){
        return new Server();
    }

}
