package SpringBootApplication.StartupFailure;

import SpringBootApplication.Data.Boo;
import SpringBootApplication.Data.Doo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DooApplication {
    //jika gagal, perbedaan menggunakan springboot dan configuration
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(DooApplication.class, args);
        Doo doo = context.getBean(Doo.class);
        System.out.println(doo);

    }

    @Bean
    public Doo doo(Boo boo){//gagal karena membuhtukan bean Boo, tetapi tidak ada bean boonya
        return new Doo();
    }

}
