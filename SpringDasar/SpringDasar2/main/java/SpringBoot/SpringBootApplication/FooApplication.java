package SpringBoot.SpringBootApplication;

import SpringDasar.Bean.Foo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FooApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Foo.class);

        Foo foo = context.getBean(Foo.class);
        System.out.println(foo);
    }
    @Bean
    public Foo foo(){
        return new Foo();
    }
}
