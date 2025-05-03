package spring_dasar.Configuration.Bean.NamedBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import spring_dasar.Data.Foo;

public class BeanNameConfiguration {

    @Bean(name = "fooFirst")//mengubah nama beannya, untuk memanggilnya bukan lagi nama methodnya melain nama bean yang sudah di set
    @Primary
    public Foo foo1(){
        Foo foo = new Foo();
        return foo;
    };

    @Bean(name = "fooSecond")
    public Foo foo2(){
        Foo foo = new Foo();
        return foo;
    };
}
