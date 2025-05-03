package Value;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SystemProperties {

    @Value(("${JAVA_HOME}"))//otomatis mengambil SpringConfig.properties dari sistem operasi
    private String java;
}
