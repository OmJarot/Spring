package SpringDasar.Optional;

import Data.Bar;
import Data.DooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OptionalTest {
    @Test
    void testOptional() {
        ApplicationContext context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);

        DooBar dooBar = context.getBean(DooBar.class);
        Bar bar = context.getBean(Bar.class);

        Assertions.assertNotNull(bar);
        Assertions.assertNotNull(dooBar);
    }
}
