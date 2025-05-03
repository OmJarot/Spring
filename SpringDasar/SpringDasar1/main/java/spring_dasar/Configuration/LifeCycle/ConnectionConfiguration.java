package spring_dasar.Configuration.LifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.LifeCycle.Connection;

@Configuration
public class ConnectionConfiguration {

    @Bean
    public Connection connection(){//meregistrasi
        return new Connection();
    }
}
