package spring_web_mvc_test.BindingResult;

import Model.Person;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BindingController {

    @PostMapping(path = "/binding", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> binding(@ModelAttribute @Valid Person person, BindingResult bindingResult){
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (!fieldErrors.isEmpty()){
            fieldErrors.forEach(fieldError -> {
                System.out.println(fieldError.getField()+" : "+ fieldError.getDefaultMessage());
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You send invalid data");
        }
        System.out.println(person);
        return ResponseEntity.ok("valid");
    }

}
