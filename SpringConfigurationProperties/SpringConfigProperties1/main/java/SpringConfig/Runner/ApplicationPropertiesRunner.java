package SpringConfig.Runner;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import SpringConfig.properties.ApplicationProperties;

@Slf4j
@Component
@AllArgsConstructor
public class ApplicationPropertiesRunner implements ApplicationRunner {
    //class ini akan di jalankan saat jar nya dijalankan
    private ApplicationProperties properties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info(properties.getName());
        log.info(String.valueOf(properties.getVersion()));
        log.info(String.valueOf(properties.getProductionMode()));
    }
}
