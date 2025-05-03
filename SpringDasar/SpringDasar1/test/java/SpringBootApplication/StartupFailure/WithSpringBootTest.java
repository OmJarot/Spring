package SpringBootApplication.StartupFailure;

import SpringBootApplication.Data.Doo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DooApplication.class)
public class WithSpringBootTest {
    //akan gagal, tetapi springboot akan mendetailkan kegagalannya/memiliki analysis akan memberikan solusinya
    @Autowired
    Doo doo;

    @Test
    void testDoo() {
        Assertions.assertNotNull(doo);
    }
}
