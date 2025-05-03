package SpringDasar.CustomScope;

import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomScopeTest {
    @Test
    void testCustomeScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CustomConfiguration.class);

        Doo doo1 = context.getBean(Doo.class);
        Doo doo2 = context.getBean(Doo.class);
        Doo doo3 = context.getBean(Doo.class);
        Doo doo4 = context.getBean(Doo.class);

        Assertions.assertNotSame(doo1,doo2);
        Assertions.assertNotSame(doo3,doo4);

        Assertions.assertSame(doo1,doo3);
        Assertions.assertSame(doo2,doo4);

    }
}
