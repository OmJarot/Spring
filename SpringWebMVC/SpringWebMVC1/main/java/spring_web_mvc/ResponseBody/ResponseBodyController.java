package spring_web_mvc.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {
    //kita bisa langsung mengembalikan otomatis menjadikan data yang dikembalikan dari Controller Method menjadi data yang ditulis

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello(@RequestParam(name = "name",required = false) String name){
        return "hello "+name;//bisa langsung print di body
    }


}
