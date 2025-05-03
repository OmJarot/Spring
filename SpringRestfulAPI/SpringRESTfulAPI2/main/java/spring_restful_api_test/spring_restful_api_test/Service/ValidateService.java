package spring_restful_api_test.spring_restful_api_test.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class ValidateService {

    private Validator validator;

    public void validate(Object request){
        Set<ConstraintViolation<Object>> violations = validator.validate(request);
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

}
