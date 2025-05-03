package spring_web_mvc.ServletIntegration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServletTest {

    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    Integer port;

    @Test
    void testServlet() {
        String hello = restTemplate.getForObject("http://localhost:" + port + "/servlet/hello", String.class);

        Assertions.assertEquals("Hello from servlet", hello.trim());

    }
}
