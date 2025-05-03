package Profile.ActiveProfile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        ActiveProfile.ProfileApplication.class
})
@ActiveProfiles({//set profile mana yang akan dijalankan
        "production"
})
public class ActiveProfile {
    //kita bisa membuat profile mana yang di aktifkan di unit test, tanpa menggantinya di application.SpringConfig.properties
    @Autowired
    ProfileApplication.SayHello sayHello;

    @Test
    void testActiveProfile() {
        Assertions.assertEquals("Hello piter from production", sayHello.sayHello("piter"));
    }

    @SpringBootApplication
    public static class ProfileApplication{

        public interface SayHello{
            String sayHello(String name);
        }
        @Component
        @Profile("local")
        public static class SayHelloLocal implements SayHello {

            @Override
            public String sayHello(String name) {
                return "Hello " + name + " from local";
            }
        }
        @Component
        @Profile("production")
        public static class SayHelloProduction implements SayHello{

            @Override
            public String sayHello(String name) {
                return "Hello "+name+ " from production";
            }
        }

    }
}
