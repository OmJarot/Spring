package spring_web_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
@ServletComponentScan
public class SpringWebMvcApplication {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder
				.connectTimeout(Duration.ofSeconds(2L))
				.readTimeout(Duration.ofSeconds(2L))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringWebMvcApplication.class, args);
	}

}