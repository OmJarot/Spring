package spring_validation.Validator;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring_validation.Data.Person;

import java.util.Set;

@SpringBootTest
public class ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void testValidatorNotValid() {
        Person person = new Person("","");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(2,violations.size());
    }

    @Test
    void testValid() {
        Person person = new Person("1","piter");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);

        Assertions.assertTrue(violations.isEmpty());
    }
}
