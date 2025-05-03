package SpringBootDasar.EventListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring_dasar.Configuration.EventListener.LoginSuccessListener;
import spring_dasar.Configuration.EventListener.UserService;
import spring_dasar.Configuration.Optional.ObjectProvider.ObjectConfiguration;

public class EventListenerTest {

    @Configuration
    @Import({
            LoginSuccessListener.class,
            UserService.class
    })
    public static class TestConfiguration{}

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    }

    @Test
    void testEvent() {
        UserService userService = context.getBean(UserService.class);

        userService.login("piter","piter");//contoh sukses
        userService.login("piter","dsa");//contoh gagal
        userService.login("das","ads");//contoh gagal
    }
}
