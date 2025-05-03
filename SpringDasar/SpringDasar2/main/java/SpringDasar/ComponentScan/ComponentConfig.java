package SpringDasar.ComponentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({
        "SpringDasar.ComponentScan.Config"//otomatis import semua configuration dari package
})
public class ComponentConfig {
}
