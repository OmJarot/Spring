package SpringBootDasar.Component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Component.ComponentConfiguration;
import spring_dasar.Configuration.Component.ProductService;

public class ComponentTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
    }

    @Test
    void testComponent() {
        ProductService productService1 = context.getBean(ProductService.class);
        ProductService productService2 = context.getBean("productService",ProductService.class);//jika menggunakan component namanya menggunakan nama class dan camelCase
        //jika menggunakan configuration NamaClass.class.getName()
    }
}
