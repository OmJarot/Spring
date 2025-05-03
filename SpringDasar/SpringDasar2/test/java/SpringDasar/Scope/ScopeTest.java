package SpringDasar.Scope;

import Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
    @Test
    void testScope() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
        Doo doo1 = context.getBean(Doo.class);
        Doo doo2 = context.getBean(Doo.class);

        Assertions.assertNotSame(doo1, doo2);//tidak sama
    }
}
