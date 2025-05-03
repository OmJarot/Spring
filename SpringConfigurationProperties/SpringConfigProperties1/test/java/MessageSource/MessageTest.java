package MessageSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest(classes = {
        Message.class
})
public class MessageTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void testMessageEN() {
        String message = messageSource.getMessage("hello", new Object[]{"piter"}, Locale.ENGLISH);
        Assertions.assertEquals("hello piter", message);
    }

    @Test
    void testMessageId() {
        String message = messageSource.getMessage("hello", new Object[]{"piter"}, new Locale("in_ID"));
        Assertions.assertEquals("halo piter", message);
    }
}
