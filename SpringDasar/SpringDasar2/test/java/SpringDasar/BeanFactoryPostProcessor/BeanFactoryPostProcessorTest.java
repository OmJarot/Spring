package SpringDasar.BeanFactoryPostProcessor;

import SpringDasar.Bean.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryPostProcessorTest {
    @Test
    void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanFactoryConfig.class);

        Foo foo = context.getBean("foo", Foo.class);

        Assertions.assertNotNull(foo);
    }
}
