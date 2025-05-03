package spring_web_mvc.Session;

import Model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @PostMapping(path = "/login/session", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        if ("piter".equals(username) && "rahasia".equals(password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new User(username));//set session ke object user

            return ResponseEntity.ok("OK");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }

    }

}
