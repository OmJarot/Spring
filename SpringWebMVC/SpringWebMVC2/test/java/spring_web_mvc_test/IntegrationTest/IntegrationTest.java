package spring_web_mvc_test.IntegrationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private Integer port;

    @Test
    void testIntegration() {
        String body = restTemplate.getForEntity("http://localhost:" + port + "/reqres", String.class).getBody();

        Assertions.assertNotNull(body);
        Assertions.assertEquals("hello guest", body.trim());
    }

    @Test
    void testParameter() {
        String body = restTemplate.getForEntity("http://localhost:" + port + "/reqres?name=piter", String.class).getBody();

        Assertions.assertNotNull(body);
        Assertions.assertEquals("hello piter", body.trim());
    }
}
