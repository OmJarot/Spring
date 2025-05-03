package spring_web_mvc_test.Validation;

import Model.Person;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValidationController {
    @ResponseBody
    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person person(@RequestBody @Valid Person person){
        return person;
    }

    @PostMapping(path = "/form/valid")
    public ResponseEntity<String> form(@ModelAttribute @Valid Person person){
        return ResponseEntity.ok("Hello "+person.getId()+" "+person.getName());
    }

}
