package Profile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        ProfileApplication.class
})
public class ProfileTest {
    @Autowired
    ProfileApplication.SayHello sayHello;

    @Test
    void testProfile() {
        Assertions.assertEquals("Hello piter from local", sayHello.hello("piter"));
    }
}
