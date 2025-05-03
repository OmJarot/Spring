package SpringBootDasar.Lazy;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Lazy.LazyConfiguration;
import spring_dasar.Data.Foo;

public class LazyTest {

    @Test
    void testLazy() {
        ApplicationContext context = new AnnotationConfigApplicationContext(LazyConfiguration.class);
        //bean foo tidak akan dibuat di awal karena sudah di set lazy
        //Foo bean = context.getBean(Foo.class); dia hanya akan dibuat ketika dipanggil saja
    }
}
