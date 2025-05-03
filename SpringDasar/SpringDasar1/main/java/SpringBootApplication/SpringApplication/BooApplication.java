package SpringBootApplication.SpringApplication;

import SpringBootApplication.Data.Boo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

//membuat aplicationContext secara otomatis
@SpringBootApplication//ini merupakan gabungan dari banyak hal
public class BooApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BooApplication.class, args);//otomatis membuat application context dan melakukan hal-hal yang dibutuhkan
        Boo boo = context.getBean(Boo.class);
    }

    @Bean
    public Boo foo(){
        return new Boo();
    }

    //untuk membuat unit testnya juga sudah di buat bisa otomatis
}
