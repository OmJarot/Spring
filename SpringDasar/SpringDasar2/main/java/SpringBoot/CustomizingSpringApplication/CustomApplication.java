package SpringBoot.CustomizingSpringApplication;

import SpringDasar.Bean.Foo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CustomApplication.class);
        application.setBannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext context = application.run(args);
        Foo foo = context.getBean(Foo.class);
    }

    @Bean
    public Foo foo(){
        return new Foo();
    }
}
