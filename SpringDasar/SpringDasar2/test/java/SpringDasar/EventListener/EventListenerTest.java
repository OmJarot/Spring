package SpringDasar.EventListener;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventListenerTest {
    @Test
    void testEventListener() {
        ApplicationContext context = new AnnotationConfigApplicationContext(EventListenerConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.login("piter", "piter");
        userService.login("piter1", "piter1");
        userService.login("piter2", "piter2");
    }
}
