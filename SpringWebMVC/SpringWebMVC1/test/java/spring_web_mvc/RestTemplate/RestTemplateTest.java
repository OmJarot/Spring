package spring_web_mvc.RestTemplate;

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

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class RestTemplateTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testAddTodo() {
        String url = "http://localhost:"+port+ "/todos";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("todo", "belajar spring webMVC");

        RequestEntity<MultiValueMap<String, Object>> request = new RequestEntity<>(form,httpHeaders, HttpMethod.POST, URI.create(url));
        ResponseEntity<List<String>> response = restTemplate.exchange(request, new ParameterizedTypeReference<>() {
        });

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("belajar spring webMVC", response.getBody().get(0));
    }

    @Test
    void testGetTodo() {
        String url = "http://localhost:"+port+ "/todos";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));

        RequestEntity<MultiValueMap<String, Object>> request = new RequestEntity<>(httpHeaders, HttpMethod.GET, URI.create(url));
        ResponseEntity<List<String>> response = restTemplate.exchange(request, new ParameterizedTypeReference<>() {
        });

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("belajar spring webMVC"));
    }
}
