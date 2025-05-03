package spring_web_mvc_test.RestTemplate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestTemplateTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testRestTemplate() {
        String url = "http://localhost:"+port+ "/todos";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        MultiValueMap<String, Object> todo = new LinkedMultiValueMap<>();
        todo.add("todo", "coding");
        todo.add("todo", "game");
        todo.add("todo", "sing");

        RequestEntity<MultiValueMap<String, Object>> request = new RequestEntity<>(todo, httpHeaders, HttpMethod.POST, URI.create(url));
        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(request, new ParameterizedTypeReference<>() {
        });

        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals("game",responseEntity.getBody().get(1));
    }

    @Test
    void testGet() {
        String url = "http://localhost:"+port+ "/todos";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        RequestEntity<MultiValueMap<String, Object>> request = new RequestEntity<>(httpHeaders, HttpMethod.GET, URI.create(url));
        ResponseEntity<List<String>> response = restTemplate.exchange(request, new ParameterizedTypeReference<List<String>>() {
        });

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
//        Assertions.assertTrue(response.getBody().contains("coding, game, sing"));
    }
}
