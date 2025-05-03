package SpringBootDasar.ObjectProvider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Optional.ObjectProvider.ObjectConfiguration;
import spring_dasar.Configuration.Optional.ObjectProvider.ObjectProviderFoo;
import spring_dasar.Configuration.Optional.OptionalConfiguration;

public class ObjectProviderTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ObjectConfiguration.class);
    }

    @Test
    void testObjectProvider() {
        ObjectProviderFoo providerFoo = context.getBean(ObjectProviderFoo.class);

        Assertions.assertEquals(3, providerFoo.getFoos().size());
    }
}
