package spring_validation.Validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {PalindromeValidator.class}
)
public @interface Palindrome {
    String message() default "{Palindrome.message}";//otomatis mencari ke messages.properties

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
