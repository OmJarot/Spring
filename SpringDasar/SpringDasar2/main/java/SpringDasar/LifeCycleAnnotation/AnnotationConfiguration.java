package SpringDasar.LifeCycleAnnotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnotationConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")//akan menjalankan method start ketika pertama kali, dan stop saat aplikasi di matikan
    public Server server(){
        return new Server();
    }

}
