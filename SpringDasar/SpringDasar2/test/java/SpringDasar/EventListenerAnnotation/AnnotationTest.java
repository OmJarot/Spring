package SpringDasar.EventListenerAnnotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {

    @Test
    void testAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedeemConfig.class);

        RedeemService service = context.getBean(RedeemService.class);
        service.cek("123");
        service.cek("1232");
        service.cek("12");
    }
}
