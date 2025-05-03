package spring_validation.MethodValidation;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring_validation.Helper.SayHello;

@SpringBootTest
public class MethodValidationTest {
    @Autowired
    private SayHello sayHello;

    @Test
    void testMethodValidation() {
        Assertions.assertEquals("Hello piter", sayHello.sayHello("piter"));
    }

    @Test
    void testNotValid() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> sayHello.sayHello(""));
    }
}
