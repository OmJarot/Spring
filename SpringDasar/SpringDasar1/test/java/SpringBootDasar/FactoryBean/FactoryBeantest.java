package SpringBootDasar.FactoryBean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_dasar.Configuration.FactoryBean.PaymentConfiguration;
import spring_dasar.Configuration.FactoryBean.PaymentGatewayClient;
import spring_dasar.Configuration.Optional.OptionalConfiguration;

public class FactoryBeantest {

    private ApplicationContext context;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(PaymentConfiguration.class);
    }

    @Test
    void testFactoryBean() {
        PaymentGatewayClient bean = context.getBean(PaymentGatewayClient.class);

        Assertions.assertEquals("https://example.com", bean.getEndPoint());
        Assertions.assertEquals("private", bean.getPrivateKey());
        Assertions.assertEquals("public", bean.getPublicKey());
    }
}
