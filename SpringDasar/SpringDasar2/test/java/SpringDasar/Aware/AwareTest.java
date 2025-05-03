package SpringDasar.Aware;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareTest {
    @Test
    void testAwar() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AuthService.class);

        AuthService authService = context.getBean(AuthService.class);

        Assertions.assertNotNull(authService.getBeanName());
        Assertions.assertSame(context, authService.getApplicationContext());
    }
}
