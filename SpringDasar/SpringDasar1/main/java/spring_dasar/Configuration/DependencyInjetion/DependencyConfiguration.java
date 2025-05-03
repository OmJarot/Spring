package spring_dasar.Configuration.DependencyInjetion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

@Configuration
public class DependencyConfiguration {
    //depedency injection
    //akan mencarikan otomatis bean yang sesuai dengan parameternya
    //jika ada bean tipe data duplicate, otomatis memilih yang primary

    @Bean
    @Primary
    public Foo foo(){
        Foo foo = new Foo();
        return foo;
    };

    @Bean
    public Bar bar(){
        Bar bar = new Bar();
        return bar;
    }

    @Bean(name = "fooSecond")
    public FooBar foobar(Foo foo, Bar bar){
        FooBar fooBar = new FooBar(foo, bar);
        return fooBar;
    };
}
