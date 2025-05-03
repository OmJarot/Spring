package spring_web_mvc.IntegrationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)//menggunakan random port yang belum digunakan
public class IntegrationTest {
    //test aplikasi dengan mengirim request langsung ke aplikasi web

    @Autowired
    TestRestTemplate restTemplate;//ini adalah httpt client

    @LocalServerPort// untuk mendapatkan port yang sedang digunakan
    Integer port;

    @Test
    void testGuest() {
        String body = restTemplate.getForEntity("http://localhost:" + port + "/reqresp", String.class)//memanggil httpnya dan dijadikan string
                .getBody();//mengambil bodynya

        Assertions.assertNotNull(body);
        Assertions.assertEquals("Hello guest", body.trim());
    }

    @Test
    void testName() {
        String body = restTemplate.getForEntity("http://localhost:" + port + "/reqresp?name=piter", String.class)//test menggunakan parameter
                .getBody();

        Assertions.assertNotNull(body);
        Assertions.assertEquals("Hello piter",body.trim());
    }
}
