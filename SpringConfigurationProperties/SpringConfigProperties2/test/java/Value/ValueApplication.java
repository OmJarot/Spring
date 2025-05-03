package Value;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ValueApplication {
    @Component
    @Getter
    public static class SampleValue{

        @Value("${application.name}")
        private String name;
        @Value("${application.version}")
        private Integer version;
        @Value("${application.production-mode}")
        private Boolean productionMode;

    }

}
