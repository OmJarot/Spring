package ApplicationProperties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(classes = {
        Application.class
})
public class ApplicationTest{
    //membaca property dari file application.SpringConfig.properties
    @Autowired
    Environment environment;//bisa menggunakan EnvironmentAware

    @Test
    void testEnvironment() {
        String property = environment.getProperty("application.name");//mengambil propertiy dari file application.SpringConfig.properties

        Assertions.assertEquals("Belajar spring boot", property);
    }
}
