package SpringBootDasar.BeanFactoryPostProsessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring_dasar.Configuration.BeanFactoryPostProsessor.FooBeanFactoryPostProsessor;
import spring_dasar.Data.Foo;

public class BeanFactoryPostProsessorTest {

    @Configuration
    @Import(FooBeanFactoryPostProsessor.class)
    public static class TestConfiguration{}

    private ConfigurableApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(TestConfiguration.class);
    }

    @Test
    void testBean() {
        Foo foo = context.getBean("foo", Foo.class);//bisa ambil foonya

        Assertions.assertNotNull(foo);
    }
}
