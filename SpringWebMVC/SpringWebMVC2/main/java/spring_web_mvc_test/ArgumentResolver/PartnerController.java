package spring_web_mvc_test.ArgumentResolver;

import Model.Partner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PartnerController {

    @GetMapping(path = "/partner")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String partner(Partner partner){
        return partner.getId()+" : "+partner.getName();
    }

}
