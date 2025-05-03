package spring_web_mvc_test.Cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CookieController {

    @PostMapping(path = "/cookie", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> cookie(@RequestParam("username") String username,
                                         @RequestParam("password") String password,
                                         HttpServletResponse response){
        if ("piter".equals(username)&& "rahasia".equals(password)){
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            response.addCookie(cookie);

            return ResponseEntity.ok("OK");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }
    }

    @GetMapping(path = "/cookie/home")
    public ResponseEntity<String> home(@CookieValue("username") String username){
        return ResponseEntity.ok("hello "+username);
    }

}
