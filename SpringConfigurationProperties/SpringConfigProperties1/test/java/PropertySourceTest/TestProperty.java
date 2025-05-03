package PropertySourceTest;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Getter
public class TestProperty {
    @Value("${sample.name}")
    private String name;

    @Value("${sample.version}")
    private Integer version;

}
