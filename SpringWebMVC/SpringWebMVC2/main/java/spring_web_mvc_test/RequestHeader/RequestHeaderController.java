package spring_web_mvc_test.RequestHeader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestHeaderController {

    @GetMapping(path = "/header")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN") String name){
        if ("PITER".equals(name)){
            return "OK";
        }else {
            return "KO";
        }
    }

}
