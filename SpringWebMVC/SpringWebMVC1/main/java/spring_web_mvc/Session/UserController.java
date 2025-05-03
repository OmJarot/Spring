package spring_web_mvc.Session;

import Model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class UserController {

    @GetMapping(path = "/user/current")
    @ResponseBody
    public String  getUser(@SessionAttribute(name = "user") User user){//mengambil sessionnya dan memasukan ke user
        return "Hello " + user.getUsername();
    }

}
