package SpringBootDasar.Bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.BeanConfiguration;
import spring_dasar.Data.Foo;

public class BeanTest {

    @Test
    void testCreate() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //methodnya akan selalu dipanggil diawal, bahkan jika kita tidak memanggil
        Assertions.assertNotNull(context);
    }

    @Test
    void testGet() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);

        Assertions.assertSame(foo1, foo2);//bean adalah singleton, sebanyak apapun object yang dibuat memanggil object yang sama
    }
}
