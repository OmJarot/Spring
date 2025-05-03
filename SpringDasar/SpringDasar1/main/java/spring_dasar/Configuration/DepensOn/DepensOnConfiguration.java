package spring_dasar.Configuration.DepensOn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

@Slf4j
public class DepensOnConfiguration {

    //mengatur urutan bean dibuat

    @Bean
    @DependsOn(value = "bar")//bean ini akan dibuat setelah membuat bean bar
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
