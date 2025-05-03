package spring_dasar.Configuration.Component.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "spring_dasar.Configuration.Component.Qualifier"
})
public class QualifierConfiguration {

    @Bean
    public Cpu cpu1(){
        return new Cpu();
    }

    @Bean
    public Cpu cpu2(){
        return new Cpu();
    }
}
