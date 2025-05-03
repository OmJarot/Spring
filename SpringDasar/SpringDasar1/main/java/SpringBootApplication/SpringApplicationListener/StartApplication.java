package SpringBootApplication.SpringApplicationListener;

import SpringBootApplication.Data.Boo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StartApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setListeners(List.of(new AppStartingListener()));//akan menjalankan appStartingListener saat start

        ConfigurableApplicationContext context = application.run(args);

        Boo boo = context.getBean(Boo.class);
        System.out.println(boo);
    }

    @Bean
    public Boo boo(){
        return new Boo();
    }
}
