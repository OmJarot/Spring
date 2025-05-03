package spring_web_mvc.BindingResult;

import Model.CreatePersonRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BindingResultController {
    //jika ingin langsung menampilkan error, tanpa ke errorHandler
    //mengambil detail error

    @PostMapping(path = "/binding", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> binding(@ModelAttribute @Valid CreatePersonRequest personRequest,
                                          BindingResult bindingResult){//jika terjadi error otomatis akan menginject binding result
//        List<ObjectError> allErrors = bindingResult.getAllErrors();//mendapatkan semua errornya
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();//mendapatkan fields yang error
        if (!fieldErrors.isEmpty()){

            fieldErrors.forEach(fieldError -> {
                System.out.println(fieldError.getField()+" : "+fieldError.getDefaultMessage());
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You send invalid data");
        }

        System.out.println(personRequest);

        return ResponseEntity.ok("valid");

    }
}
