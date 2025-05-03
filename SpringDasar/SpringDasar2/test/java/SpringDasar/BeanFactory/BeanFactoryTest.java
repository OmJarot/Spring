package SpringDasar.BeanFactory;

import SpringDasar.Bean.Foo;
import SpringDasar.Bean.FooConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class BeanFactoryTest {
    @Test
    void testBeanFactory() {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(FooConfiguration.class);

        ObjectProvider<Foo> foo = context.getBeanProvider(Foo.class);
        List<Foo> list = foo.stream().toList();
        System.out.println(list.size());

        Map<String, Foo> beansOfType = context.getBeansOfType(Foo.class);

        System.out.println(beansOfType);
    }
}
