package spring_web_mvc.ErrorHandler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//controller untuk menghandle error, otomatis menjadi bean
public class ErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)//hanya akan di panggil jika terjadi error methodArgumentNotValidExecption
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException exception){//parameternya otomatis di inject
        return ResponseEntity.badRequest().body("Validation Error "+ exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> constraintViolationException(ConstraintViolationException exception){
        return ResponseEntity.badRequest().body("Validation Error "+ exception.getMessage());
    }

}
