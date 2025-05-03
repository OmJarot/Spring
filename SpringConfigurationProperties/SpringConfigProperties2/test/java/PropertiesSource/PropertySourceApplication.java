package PropertiesSource;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:/sample.properties")
})
public class PropertySourceApplication {

    @Component
    @Getter
    public static class SamplePropertySource{
        @Value("${sample.name}")
        private String name;
        @Value("${sample.version}")
        private Integer version;

    }
}
