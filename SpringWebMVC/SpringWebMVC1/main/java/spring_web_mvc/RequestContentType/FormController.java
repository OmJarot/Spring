package spring_web_mvc.RequestContentType;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    //consume adalah content type yang diterima
    @PostMapping(path = "/form/sayhello", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)//set contentype yang di kirim hanya bisa form urlencoded
    @ResponseBody
    public String sayHello(@RequestParam(name = "name") String name){
        return "Hello "+ name;
    }

}
