package SpringBoot.SpringApplicationEvent;

import SpringDasar.Bean.Foo;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
@SpringBootApplication
public class EventApplication {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(EventApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.setListeners(List.of(new AppStartingListener()));

        ConfigurableApplicationContext context = application.run(args);

        Foo bean = context.getBean(Foo.class);
        System.out.println(bean);

    }
    @Bean
    public Foo foo(){
        return new Foo();
    }
}
