package spring_validation.MessageSource;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring_validation.Data.Foo;

import java.util.Set;

@Slf4j
@SpringBootTest
public class MessagesTest {

    @Autowired
    private Validator validator;

    @Test
    void testMessages() {
        Foo foo = new Foo("piter");

        Set<ConstraintViolation<Foo>> violations = validator.validate(foo);

        for (var violation : violations){
            log.info(violation.getMessage());
        }
        String message = violations.stream().findFirst().get().getMessage();
        Assertions.assertEquals("Data bukan palindrome", message);
    }
}
