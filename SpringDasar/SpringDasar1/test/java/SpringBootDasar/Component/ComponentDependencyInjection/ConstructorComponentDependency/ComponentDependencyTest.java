package SpringBootDasar.Component.ComponentDependencyInjection.ConstructorComponentDependency;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency.ComponentDependencyConfig;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency.MultiComponent;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency.ProductRepository;
import spring_dasar.Configuration.Component.ComponentDependencyInjection.ConstructorComponentDependency.ProductService;

public class ComponentDependencyTest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(ComponentDependencyConfig.class);
    }

    @Test
    void testComponent() {
        ProductService service = context.getBean(ProductService.class);
        ProductRepository repository = context.getBean(ProductRepository.class);

        Assertions.assertSame(repository, service.getProductRepository());
    }

    @Test
    void testMultiConstructor() {
        MultiComponent multi = context.getBean(MultiComponent.class);
        ProductRepository repository = context.getBean(ProductRepository.class);

        Assertions.assertSame(repository, multi.getProductRepository());
    }
}
