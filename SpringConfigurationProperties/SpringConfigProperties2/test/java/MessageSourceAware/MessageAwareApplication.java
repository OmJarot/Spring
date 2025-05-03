package MessageSourceAware;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootApplication
public class MessageAwareApplication {

    @Component
    public static class MessageAware implements MessageSourceAware{

        @Setter
        private MessageSource messageSource;

        public String hello(Locale locale){
            return messageSource.getMessage("hello", new Object[]{"piter"},locale);
        }
    }

}
