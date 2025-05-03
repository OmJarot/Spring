package SpringBootDasar.Inheritance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.Inheritance.MerchantConfiguration;
import spring_dasar.Configuration.Inheritance.MerchantService;
import spring_dasar.Configuration.Inheritance.MerchantServiceImpl;

public class InheritanceTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MerchantConfiguration.class);
    }

    @Test
    void testInheritance() {//menggunakan parentnya
        MerchantService merchantService = applicationContext.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = applicationContext.getBean(MerchantServiceImpl.class);//menggunakan parentnya

        Assertions.assertSame(merchantService,merchantServiceImpl);
    }
}
