package ProfilePropertiesFile;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfileFileApplication {
    //saat menggunakan profile, profile yang diactive kan juga akan men-include file profilenya
    //contoh misal profilenya adalah production maka file application-production.SpringConfig.properties akan dibaca juga

    @Component
    @Getter
    public static class ProfileProperties{
        //jika profilenya active maka otomatis akan membaca variabel dari filenya profilenya
        @Value("${profile.default}")
        private String defaultFile;

        @Value("${profile.production}")
        private String productionFile;

        @Value("${profile.test}")
        private String testFile;

    }
}
