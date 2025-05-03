package spring_dasar.Configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Data.Foo;


@Slf4j
@Configuration
public class BeanConfiguration {
    //bean adalah sebuah object kita masukkan kedalam Spring Container IoC
    //cara membuat bean

    //bean akan selalu dibuat diawal saat pertama kali aplikasi dijalankan bahkan sebelum kita melakukan get

    @Bean//menandakan ini adalah bean
    public Foo foo(){//untuk nama mengikuti nama method, contohnya nama bean ini adalah foo
        Foo foo = new Foo();
        log.info("Create new foo");//bean akan otomatis dipanggil di awal, artinya diawal akan dibuat dahulu objectnya
        return foo;
    }
}
