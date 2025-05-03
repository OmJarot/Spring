package Environment;

import lombok.Setter;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvAware implements EnvironmentAware {
    //menggunakan environmentAware
    @Setter
    private Environment environment;

    public String getEnv(String property){
        return environment.getProperty(property);
    }
}
