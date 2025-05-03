package spring_web_mvc_test.RequestBody;

import Model.HelloRequest;
import Model.HelloResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestBodyController {
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(value = "/json",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String json(@RequestBody String requestBody) throws JsonProcessingException {
        HelloRequest response = objectMapper.readValue(requestBody, HelloRequest.class);

        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setHello("Hello "+ response.getName());

        return objectMapper.writeValueAsString(helloResponse);
    }

}
