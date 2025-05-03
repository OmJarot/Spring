package MessageSourceSpringBoot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest(classes = {
        MessageConfig.class
})
public class MessageSpringBootTest {
    @Autowired
    MessageSpring messageSpring;

    @Test
    void testMessage() {
        Assertions.assertEquals("hello piter",messageSpring.hello(Locale.ENGLISH));
        Assertions.assertEquals("halo piter",messageSpring.hello(new Locale("in_ID")));
    }
}
