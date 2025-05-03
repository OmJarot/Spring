package Environment;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class EnvironmentApplication {
    @Component
    public static class SampleEnv implements EnvironmentAware{

        @Setter
        private Environment environment;

        public String getEnv(String property){
            return environment.getProperty(property);
        }

    }
}
