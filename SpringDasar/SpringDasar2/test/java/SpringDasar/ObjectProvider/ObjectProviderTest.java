package SpringDasar.ObjectProvider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ObjectProviderTest {
    @Test
    void testObjectProvider() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ObjectProviderConfig.class);

        MultiDoo doo = context.getBean(MultiDoo.class);

        Assertions.assertEquals(3, doo.getDoos().size());
    }
}
