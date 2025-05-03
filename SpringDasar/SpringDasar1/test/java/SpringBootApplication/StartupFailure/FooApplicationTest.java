package SpringBootApplication.StartupFailure;

import SpringBootApplication.Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FooApplicationTest {
    //akan gagal
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(DooApplication.class);
    }

    @Test
    void testDoo() {
        Doo doo = context.getBean(Doo.class);
    }
}
