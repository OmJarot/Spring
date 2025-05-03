package spring_web_mvc_test.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EntityController {

    @PostMapping(path = "/entity", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> entity(String username, String password){
        if ("piter".equals(username) && "rahasia".equals(password)){
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("KO");
        }
    }

}
