package SpringBootDasar.Aware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Aware.AuthService;
import spring_dasar.Configuration.Aware.AwareConfiguration;

public class AwareTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(AwareConfiguration.class);
    }

    @Test
    void testAware() {

        AuthService authService = context.getBean(AuthService.class);

        Assertions.assertEquals("spring_dasar.Configuration.Aware.AuthService", authService.getNameBean());
        Assertions.assertNotNull(authService.getContext());
        Assertions.assertSame(context, authService.getContext());

    }
}
