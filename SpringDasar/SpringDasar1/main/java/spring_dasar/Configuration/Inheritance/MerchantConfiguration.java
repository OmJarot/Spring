package spring_dasar.Configuration.Inheritance;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MerchantServiceImpl.class})
public class MerchantConfiguration {
}
