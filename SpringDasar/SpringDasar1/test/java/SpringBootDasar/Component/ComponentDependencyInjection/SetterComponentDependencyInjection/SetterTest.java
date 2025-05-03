package SpringBootDasar.Component.ComponentDependencyInjection.SetterComponentDependencyInjection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.SetterComponentDependecyInjection.Brand;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.SetterComponentDependecyInjection.Product;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.SetterComponentDependecyInjection.SetterConfiguration;

public class SetterTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(SetterConfiguration.class);
    }

    @Test
    void testSetter() {
        Product product = context.getBean(Product.class);
        Brand brand = context.getBean(Brand.class);

        Assertions.assertSame(brand, product.getBrand());
    }
}
