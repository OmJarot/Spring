package Value;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ApplicationProperties {

    @Value("${application.name}")//otomatis mengambil value dari application.SpringConfig.properties
    private String name;//otomatis di konversi misal dari string ke integer

    @Value("${application.version}")
    private Integer version;

    @Value("${application.production-mode}")
    private Boolean productionMode;

    @Value("${JAVA_HOME}") //mengambil variabel SpringConfig.properties dari sistem operasi
    private String java;
}
