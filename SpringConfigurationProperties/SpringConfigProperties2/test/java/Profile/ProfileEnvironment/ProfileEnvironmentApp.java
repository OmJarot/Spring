package Profile.ProfileEnvironment;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
public class ProfileEnvironmentApp {
    @Component
    public static class ProfilEnv implements EnvironmentAware{

        @Setter
        private Environment environment;

        public String[] getActive(){
            return environment.getActiveProfiles();
        }

    }

}
