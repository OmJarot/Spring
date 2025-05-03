package spring_aop.AOP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloService {

    public String hello(String name){
        log.info("Call helloService.hello()");
        return "Hello "+name;
    }

    public String bye(String name){
        log.info("Call helloService.bye()");
        return "Bye "+name;
    }

    public String test(){
        log.info("Call helloService.test()");
        return "Test";
    }

}
