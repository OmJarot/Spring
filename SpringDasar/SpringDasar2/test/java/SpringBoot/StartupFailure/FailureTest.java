package SpringBoot.StartupFailure;

import SpringDasar.Bean.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FailureApplication.class)
public class FailureTest {
    //jika error memiliki analisis untuk errornya
    @Autowired
    Foo foo;

    @Test
    void testFailure() {
        Assertions.assertNotNull(foo);
    }
}
