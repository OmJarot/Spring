package SpringDasar.ComponentDependency.ConstructorDependency;

import SpringDasar.ComponentDependency.ComponentDependencyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorTest {

    @Test
    void testConstructor() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentDependencyConfig.class);

        ProductService productService = context.getBean(ProductService.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Assertions.assertNotNull(productService);
        Assertions.assertNotNull(productRepository);

        Assertions.assertSame(productRepository, productService.getProductRepository());
    }
}
