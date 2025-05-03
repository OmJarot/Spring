package spring_web_mvc_test.SessionAttribute;

import Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

    @GetMapping(path = "/user")
    @ResponseBody
    public String user(@SessionAttribute User user){
        return "Hello "+user.getUser();
    }

}
