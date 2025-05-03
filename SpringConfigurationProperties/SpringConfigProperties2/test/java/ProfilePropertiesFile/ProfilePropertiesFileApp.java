package ProfilePropertiesFile;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfilePropertiesFileApp {

    @Component
    @Getter
    public static class SampleProfileFile{
        @Value("${profile.default}")
        private String defaultFile;

        @Value("${profile.production}")
        private String productionFile;

        @Value("${profile.test}")
        private String testFile;
    }

}
