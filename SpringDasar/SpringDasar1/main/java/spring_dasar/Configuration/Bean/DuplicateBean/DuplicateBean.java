package spring_dasar.Configuration.Bean.DuplicateBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.Foo;

@Configuration
public class DuplicateBean {
    //membuat bean dengan tipe data yang sama, nama bean harus berbeda
    //dan saat memanggil beannya harus menyebutkan nama beannya

    @Bean
    public Foo foo1(){
        Foo foo = new Foo();
        return foo;
    };

    @Bean
    public Foo foo2(){
        Foo foo = new Foo();
        return foo;
    };

}
