package SpringDasar.CustomScope;

import Data.Doo;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class CustomConfiguration {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubleScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Doo boo(){
        return new Doo();
    }

}
