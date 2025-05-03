package SpringDasar.Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({//import configuration
        BarConfig.class,
        DooConfig.class
})
public class MainConfig {

}
