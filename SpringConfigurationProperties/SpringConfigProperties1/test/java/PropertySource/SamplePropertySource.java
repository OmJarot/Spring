package PropertySource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class SamplePropertySource {
    //menambahkan property selain application.SpringConfig.properties
    //nama variable tidak boleh sama dengan yang ada di application.SpringConfig.properties

    @Value("${sample.name}")//otomatis membaca dari sample.properties
    private String name;

    @Value("${sample.version}")
    private Integer version;

}
