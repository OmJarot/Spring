package SpringBoot.StartupFailure;

import Data.Bar;
import SpringDasar.Bean.Foo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FailureApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(FailureApplication.class);

        Foo bean = context.getBean(Foo.class);
    }
    @Bean
    public Foo foo(Bar bar){
        return new Foo();
    }
}
