package SpringBootApplication.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//spring boot akan otomatis meng-scan semua package nya sendiri
public class CommandApp {
    public static void main(String[] args) {
        SpringApplication.run(CommandApp.class, args);

    }
}
