package SpringBootDasar.Bean.DuplicateBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Bean.DuplicateBean.DuplicateBean;
import spring_dasar.Data.Foo;

public class DuplicateBeanTest {

    @Test
    void testError() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DuplicateBean.class);

        //jika memiliki bean dengan tipe data sama, tetapi saat get tidak menyebutkan nama beannya
        //akan mengakibatkan error
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->{
            Foo foo = context.getBean(Foo.class);
        });
    }

    @Test
    void testDuplicate() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(DuplicateBean.class);

        //memanggil menggunakan nama beannya
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1,foo2);//foo1 dan foo2 tidak sama karena berasal dari bean yang berbeda
    }
}
