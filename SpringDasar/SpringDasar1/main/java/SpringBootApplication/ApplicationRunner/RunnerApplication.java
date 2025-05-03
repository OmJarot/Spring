package SpringBootApplication.ApplicationRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);//untuk edit argumentnya bisa dari edit configuration, program argument, tambahkan --profiles=piter --profiles=ganteng
    }
}
