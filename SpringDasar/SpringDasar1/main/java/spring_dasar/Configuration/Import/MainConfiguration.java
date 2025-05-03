package spring_dasar.Configuration.Import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({//menampung banyak configuration dalam 1 class
        BarConfiguration.class,
        FooConfiguration.class
})
public class MainConfiguration {
}
