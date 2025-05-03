package spring_validation.MethodOverriding;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodOverriding {

    @Autowired
    private SayHi sayHi;

    @Test
    void testMethodOverriding() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> sayHi.sayHi(""));

    }
}
