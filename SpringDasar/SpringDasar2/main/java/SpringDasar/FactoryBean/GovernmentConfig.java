package SpringDasar.FactoryBean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        GovernmentBean.class
})
public class GovernmentConfig {
}
