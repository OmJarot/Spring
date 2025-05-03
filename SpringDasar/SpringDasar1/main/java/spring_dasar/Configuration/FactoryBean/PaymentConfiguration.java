package spring_dasar.Configuration.FactoryBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = PaymentGatewayClientFactoryBean.class)
public class PaymentConfiguration {
}
