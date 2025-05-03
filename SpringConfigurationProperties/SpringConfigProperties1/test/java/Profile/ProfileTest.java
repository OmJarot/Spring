package Profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@SpringBootTest(classes = {
        ProfileTest.TestApplication.class
})
public class ProfileTest {

    @Autowired
    TestApplication.SayHello sayHello;//otomatis mencari class implementasi nya sesuai spring.profiles.active

    @Test
    void testProfile() {
        Assertions.assertEquals("Hello piter from local", sayHello.sayHello("piter"));
    }

    @SpringBootApplication
    public static class TestApplication{

        public interface SayHello{
            String sayHello(String name);
        }

        @Component
        @Profile("local")//ini akan di jalankan karena spring.profiles.active=local (ada di application.SpringConfig.properties)
        public static class SayHelloLocal implements SayHello{

            @Override
            public String sayHello(String name) {
                return "Hello "+ name + " from local";
            }

        }

        @Component
        @Profile("production")//tidak akan dijalankan karena spring.profiles.active tidak di set untuk profile production
        public static class SayHelloProduction implements SayHello{

            @Override
            public String sayHello(String name) {
                return "Hello "+ name + " from local";
            }

        }

    }

}
