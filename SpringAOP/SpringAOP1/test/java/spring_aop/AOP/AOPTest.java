package spring_aop.AOP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AOPTest {

    @Autowired
    HelloService helloService;

    @Test
    void testAOP() {
        Assertions.assertEquals("Hello piter", helloService.hello("piter"));
        Assertions.assertEquals("Bye piter", helloService.bye("piter"));
        Assertions.assertEquals("Test", helloService.test());
    }
}
