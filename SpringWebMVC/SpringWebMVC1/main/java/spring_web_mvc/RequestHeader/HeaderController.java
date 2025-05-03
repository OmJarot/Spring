package spring_web_mvc.RequestHeader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping(path = "/header/token")
    @ResponseBody
    public String header(@RequestHeader(name = "X-TOKEN") String header){//mengirim data header x-token ke string header
        if ("PITER".equals(header)){
            return "OK";
        }else {
            return "KO";
        }
    }

}
