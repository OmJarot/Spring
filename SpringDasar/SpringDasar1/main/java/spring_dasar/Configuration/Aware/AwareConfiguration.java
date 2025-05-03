package spring_dasar.Configuration.Aware;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AuthService.class)
public class AwareConfiguration {

}
