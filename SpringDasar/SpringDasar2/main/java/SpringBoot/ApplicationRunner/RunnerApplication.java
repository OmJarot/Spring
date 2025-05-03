package SpringBoot.ApplicationRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RunnerApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RunnerApplication.class, args);
    }
}
