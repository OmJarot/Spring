package SpringBootDasar.BeanFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Optional.ObjectProvider.ObjectConfiguration;
import spring_dasar.Data.Foo;

import java.util.List;
import java.util.Map;

public class BeanFactoryTest {
    //ConfigurableApplicationContext merupakan parent dari applicationcontext
    //juga beanFactory
    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ObjectConfiguration.class);
    }

    @Test
    void test() {
        ObjectProvider<Foo> beanProvider = context.getBeanProvider(Foo.class);//ini adalah method dari beanFactory
        List<Foo> list = beanProvider.stream().toList();//mengambil semua bean dengan tipe data sama
        System.out.println(list);

        //ConfigurableApplicationContext
        Map<String, Foo> beansOfType = context.getBeansOfType(Foo.class);//mengambil semua bean dengan tipe data sama, jugaq mengambil namanya sebagai key
        System.out.println(beansOfType);
    }
}
