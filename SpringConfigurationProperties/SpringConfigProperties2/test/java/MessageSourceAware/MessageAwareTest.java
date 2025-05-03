package MessageSourceAware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest(classes = {
        MessageAwareApplication.class
})
public class MessageAwareTest {
    @Autowired
    MessageAwareApplication.MessageAware messageAware;

    @Test
    void testMessageAware() {
        Assertions.assertEquals("hello piter", messageAware.hello(Locale.ENGLISH));
        Assertions.assertEquals("halo piter", messageAware.hello(new Locale("in_ID")));
    }
}
