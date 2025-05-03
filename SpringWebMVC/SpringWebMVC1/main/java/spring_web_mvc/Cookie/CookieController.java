package spring_web_mvc.Cookie;

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
    public ResponseEntity<String> cookie(@RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password,
                                         HttpServletResponse response){
        if ("piter".equals(username) && "rahasia".equals(password)){
            Cookie cookie = new Cookie("username",username);
            cookie.setPath("/");
            response.addCookie(cookie);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }
    }

    @GetMapping("/cookie/home")
    public ResponseEntity<String> home(@CookieValue("username") String username){//mengambil cookie
        return ResponseEntity.ok("Hello "+ username);
    }

}
