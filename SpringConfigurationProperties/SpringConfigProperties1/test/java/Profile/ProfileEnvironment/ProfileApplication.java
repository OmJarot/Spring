package Profile.ProfileEnvironment;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfileApplication {

    @Component
    public static class SampleProfile implements EnvironmentAware {
        //mengambil data profile mana saja yang active
        @Setter
        private Environment environment;

        public String[] getActive(){
            return environment.getActiveProfiles();
        }
    }

}
