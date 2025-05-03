package spring_web_mvc.Json;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import Model.CreatePersonRequest;

@Controller
public class JsonController {

    @PostMapping(path = "/json",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CreatePersonRequest createPerson(@RequestBody CreatePersonRequest request){//otomatis membuat jsonnya
        return request;//returnnya juga otomatis adalah json
    }

}
