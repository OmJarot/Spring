package Profile.ActiveProfile;

import Profile.ProfileApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        ProfileApplication.class
})
@ActiveProfiles("local")
public class ActiveTest {

    @Autowired
    ProfileApplication.SayHello sayHello;

    @Test
    void testActive() {
        Assertions.assertEquals("Hello piter from local", sayHello.hello("piter"));
    }
}
