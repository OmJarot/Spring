package spring_dasar.Configuration.LifeCycle;

import org.springframework.context.annotation.Bean;
import spring_dasar.Data.LifeCycle.PrePost;

public class PrePostConfiguration {

    @Bean
    public PrePost prePost(){
        return new PrePost();
    }
}
