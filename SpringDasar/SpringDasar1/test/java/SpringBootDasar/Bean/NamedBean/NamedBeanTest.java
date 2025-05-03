package SpringBootDasar.Bean.NamedBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Bean.NamedBean.BeanNameConfiguration;
import spring_dasar.Data.Foo;

public class NamedBeanTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
         context = new AnnotationConfigApplicationContext(BeanNameConfiguration.class);
    }

    @Test
    void testName() {
        Foo foo = context.getBean(Foo.class);

        //untuk mengaksesnya sekarang menggunakan nama bean yang sudah di set
        Foo foo1 = context.getBean("fooFirst", Foo.class);
        Foo foo2 = context.getBean("fooSecond", Foo.class);

        Assertions.assertSame(foo, foo1);
        Assertions.assertNotSame(foo1, foo2);
    }
}
