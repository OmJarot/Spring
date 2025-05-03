package SpringBootDasar.EventListenerAnnotation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import spring_dasar.Configuration.EventListenerAnnotation.RedeemService;

public class EventListenerAnnotationTest {

    @Configuration
    @ComponentScan({
            "spring_dasar.Configuration.EventListenerAnnotation"
    })
    public static class TestConfig{}

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestConfig.class);
    }

    @Test
    void testListener() {
        RedeemService redeemService = context.getBean(RedeemService.class);
        redeemService.redeem("123");//success
        redeemService.redeem("1233");//fail
    }
}
