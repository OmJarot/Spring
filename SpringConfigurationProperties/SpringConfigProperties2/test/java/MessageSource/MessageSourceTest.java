package MessageSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest(classes = {
        MessageSourceApplication.class
})
public class MessageSourceTest {

    @Autowired
    MessageSource messageSource;

    @Test
    void testMessageSource() {
        String message = messageSource.getMessage("hello", new Object[]{"piter"}, Locale.ENGLISH);
        Assertions.assertEquals("hello piter",message);
    }
}
