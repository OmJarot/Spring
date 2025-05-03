package SpringBootApplication.CustomizingSpringApplication;

import SpringBootApplication.Data.Boo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Customizing {
    public static void main(String[] args) {
        //membuat pengaturan di spring application sebelum application context dibuat
        SpringApplication application = new SpringApplication(Customizing.class);
        application.setBannerMode(Banner.Mode.OFF);//mematikan banner
        ConfigurableApplicationContext context = application.run(args);

        Boo boo = context.getBean(Boo.class);
    }

    @Bean
    public Boo boo(){
        return new Boo();
    }
}
