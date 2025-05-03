package PropertySource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({//registrasi property nya
        @PropertySource("classpath:/sample.properties")
})
public class SampleSpring {
}
