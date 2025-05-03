package SpringBootApplication.CustomizingSpringApplication;

import SpringBootApplication.Data.Boo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Customizing.class)
public class CustomTest {

    @Autowired
    Boo boo;

    @Test
    void test() {

    }
}
