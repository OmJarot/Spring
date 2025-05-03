package spring_web_mvc_test.ServletIntegration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ServletIntegrationTest {
    @Autowired
    TestRestTemplate restTemplate;

    @LocalServerPort
    private Integer port;

    @Test
    void testIntegration() {
        String forObject = restTemplate.getForObject("http://localhost:" + port + "/servlet", String.class);
        Assertions.assertEquals("Hello piter", forObject.trim());
    }
}
