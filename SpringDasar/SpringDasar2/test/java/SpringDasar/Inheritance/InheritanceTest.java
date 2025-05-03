package SpringDasar.Inheritance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InheritanceTest {
    @Test
    void testInheritance() {
        ApplicationContext context = new AnnotationConfigApplicationContext(InheritanceConfig.class);

        MerchantService merchantService = context.getBean(MerchantService.class);
        MerchantServiceImp merchantServiceImp = context.getBean(MerchantServiceImp.class);

        Assertions.assertSame(merchantServiceImp, merchantService);
    }
}
