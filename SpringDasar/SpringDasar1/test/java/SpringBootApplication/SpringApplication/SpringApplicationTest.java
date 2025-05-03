package SpringBootApplication.SpringApplication;

import SpringBootApplication.Data.Boo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = BooApplication.class)
public class SpringApplicationTest {
    
    @Autowired
    Boo boo;//otomatis di inject oleh springnya, tidak perlu get bean lagi menggunakan applicationContext, disarankan tidak privet agar tidak di inject oleh menggunakan reflection

    @Test
    void testSpringApplication() {
        Assertions.assertNotNull(boo);
    }
}
