package spring_web_mvc_test.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> method(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body("Validation error " +exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> violation(ConstraintViolationException exception){
        return ResponseEntity.badRequest().body("Validation error " +exception.getMessage());
    }

}
