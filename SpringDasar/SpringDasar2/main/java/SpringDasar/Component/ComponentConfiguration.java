package SpringDasar.Component;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        See.class
})
//bisa menggunakan componentscan juga
public class ComponentConfiguration {
}
