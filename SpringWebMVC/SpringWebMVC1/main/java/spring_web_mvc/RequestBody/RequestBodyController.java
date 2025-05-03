package spring_web_mvc.RequestBody;

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
    //mengirim data lewat Request Body dalam bentuk format data seperti JSON, XML, dan sejenisnya

    @Autowired
    private ObjectMapper objectMapper;

    @ResponseBody
    @PostMapping(
            path = "/body/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,//set request data
            produces = MediaType.APPLICATION_JSON_VALUE//set mengembalikan data apa
    )
    public String body(@RequestBody String requestBody) throws JsonProcessingException {//data request body akan disimpan di requestBody
        HelloRequest request = objectMapper.readValue(requestBody, HelloRequest.class);//json menjadi object

        HelloResponse response = new HelloResponse();
        response.setHello("Hello "+request.getName());

        return objectMapper.writeValueAsString(response);//ubah object menjadi json
    }

}
