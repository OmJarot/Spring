package SpringBootDasar.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Optional.OptionalConfiguration;
import spring_dasar.Data.Foo;
import spring_dasar.Data.FooBar;

public class OptionalTest {
    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
    }

    @Test
    void testOptional() {
        FooBar fooBar = context.getBean(FooBar.class);
        Foo foo = context.getBean(Foo.class);


        Assertions.assertNull(fooBar.getBar());
        Assertions.assertSame(foo, fooBar.getFoo());
    }
}
