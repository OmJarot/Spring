package spring_web_mvc.RestTemplate;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

//@SpringBootApplication
public class SpringApp {

    //membuat restTamplate
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder){
//        return builder
//                .connectTimeout(Duration.ofSeconds(2L))
//                .readTimeout(Duration.ofSeconds(2L))
//                .build();
//    }

}
