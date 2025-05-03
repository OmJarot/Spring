package spring_dasar.Configuration.ComponentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {//mengimport semua configuration yang ada di package dan sub packagenya
        "spring_dasar.Configuration.Import"//otomatis mengimport semua configuration yang ada di package Import
})
public class ComponentConfiguration {

}
