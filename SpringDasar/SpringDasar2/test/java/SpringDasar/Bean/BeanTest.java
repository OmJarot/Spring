package SpringDasar.Bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(FooConfiguration.class);
    }

    @Test
    void testBean() {
        Foo bean1 = context.getBean(Foo.class);
        Foo bean2 = context.getBean(Foo.class);

        Assertions.assertSame(bean1,bean2);
    }
}
