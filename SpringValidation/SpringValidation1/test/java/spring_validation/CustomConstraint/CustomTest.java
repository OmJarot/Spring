package spring_validation.CustomConstraint;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring_validation.Data.Foo;

import java.util.Set;

@SpringBootTest
public class CustomTest {
    @Autowired
    private Validator validator;

    @Test
    void testCustomNotValid() {
        Foo foo = new Foo("piter");
        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    void testValid() {
        Foo foo = new Foo("kodok");
        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);

        Assertions.assertTrue(violations.isEmpty());
    }
}
