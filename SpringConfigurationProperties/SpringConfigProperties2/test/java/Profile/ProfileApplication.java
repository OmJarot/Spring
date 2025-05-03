package Profile;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
@SpringBootApplication
public class ProfileApplication {

    public interface SayHello{
        String hello(String name);
    }

    @Component
    @Profile("local")
    public static class SayHelloLocal implements SayHello{
        @Override
        public String hello(String name) {
            return "Hello "+ name +" from local";
        }
    }

    @Component
    @Profile("production")
    public static class SayHelloProduction implements SayHello{
        @Override
        public String hello(String name) {
            return "Hello "+ name +" from ";
        }
    }
}
