package spring_dasar.Configuration.CustomScope;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import spring_dasar.Data.Foo;
import spring_dasar.Scope.DoubleScope;

@Slf4j
public class CustomConfiguration {
    //menggunakan scope custom

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){//mendaftarkan scope yang telah dibuat
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubleScope());//set nama dan scopenya
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Foo foo(){
        log.info("create new Foo");
        return new Foo();
    }

}
