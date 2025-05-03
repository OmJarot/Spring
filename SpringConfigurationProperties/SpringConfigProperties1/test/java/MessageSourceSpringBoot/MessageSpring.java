package MessageSourceSpringBoot;

import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageSpring implements MessageSourceAware {//bisa menggunakan applicationcontext atau messageSourceAware
    //otomatis menggunakan spring boot

    @Setter
    private MessageSource messageSource;

    public String hello(Locale locale){
        return messageSource.getMessage("hello", new Object[]{"piter"},locale);//otomatis membaca file messages.properties
    }

}
