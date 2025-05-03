package spring_dasar.Configuration.Lazy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;

@Slf4j
@Configuration
public class LazyConfiguration {

    @Bean
    @Lazy//bean ini tidak akan di buat diawal/saat aplikasi pertama kali start
    //bean ini akan di buat saat di get
    public Foo foo(){
        log.info("Create new Foo");
        return new Foo();
    };

    @Bean
    public Bar bar(){
        log.info("Create new Bar");
        return new Bar();
    }

}
