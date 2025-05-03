package spring_web_mvc.Validation;

import Model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ValidationController {

    @PostMapping(
            path = "/valid/json",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CreatePersonRequest validation (@RequestBody @Valid CreatePersonRequest request){//@Valid akan melakukan validation di objectnya, jika error akan mengembalikan status 400 atau badrequest
        return request;
    }

    @PostMapping(path = "/valid/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> form(@ModelAttribute @Valid CreatePersonRequest request){
        return ResponseEntity.ok("Hello "+request.getFirstName() +request.getMiddleName()+ request.getLastName());
    }

}
