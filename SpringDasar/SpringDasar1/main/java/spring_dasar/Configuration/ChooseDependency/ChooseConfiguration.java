package spring_dasar.Configuration.ChooseDependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring_dasar.Data.Bar;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

@Configuration
public class ChooseConfiguration {
    //depedency injection
    //akan mencarikan otomatis bean yang sesuai dengan parameternya
    //jika ada bean tipe data duplicate, otomatis memilih yang primary
    //jika ingin menentukan bean mana yang akan di pilih gunakan annotation qualifier

    @Bean
    @Primary
    public Foo foo(){
        Foo foo = new Foo();
        return foo;
    };

    @Bean(name = "foo2")
    public Foo fooSecond(){
        Foo foo = new Foo();
        return foo;
    };

    @Bean
    public Bar bar(){
        Bar bar = new Bar();
        return bar;
    }

    @Bean(name = "fooSecond")
    public FooBar foobar(@Qualifier("foo2") Foo foo, Bar bar){//akan memilih bean dengan nama foo2
        FooBar fooBar = new FooBar(foo, bar);
        return fooBar;
    };
}
