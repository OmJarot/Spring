package spring_web_mvc.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {

    @Autowired
    HelloService helloService;//otomatis menggunakan class implementasinya

    @Test
    void testService() {
        Assertions.assertEquals("Hello guest", helloService.hello(null));
        Assertions.assertEquals("Hello piter", helloService.hello("piter"));
    }
}
