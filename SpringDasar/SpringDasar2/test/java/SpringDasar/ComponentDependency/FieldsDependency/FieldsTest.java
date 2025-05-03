package SpringDasar.ComponentDependency.FieldsDependency;

import SpringDasar.ComponentDependency.ComponentDependencyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FieldsTest {
    @Test
    void testFields() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ComponentDependencyConfig.class);

        CustomerService customerService = context.getBean(CustomerService.class);
        CustomerRepository customerRepository = context.getBean(CustomerRepository.class);

        Assertions.assertNotNull(customerService);
        Assertions.assertNotNull(customerRepository);

        Assertions.assertSame(customerRepository, customerService.getCustomerRepository());
    }
}
