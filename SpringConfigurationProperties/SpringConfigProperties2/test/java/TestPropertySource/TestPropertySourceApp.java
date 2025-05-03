package TestPropertySource;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
@SpringBootApplication
public class TestPropertySourceApp {
    @Getter
    @Component
    public static class SamplePropertyTest{
        @Value("${test.name}")
        private String name;
        @Value("${test.version}")
        private Integer version;

    }

}
