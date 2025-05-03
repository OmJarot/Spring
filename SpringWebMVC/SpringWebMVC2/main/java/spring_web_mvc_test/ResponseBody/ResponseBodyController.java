package spring_web_mvc_test.ResponseBody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

    @GetMapping(path = "/responseBody")
    @ResponseBody
    public String hello(String name){
        return "Hello "+name;
    }

}
