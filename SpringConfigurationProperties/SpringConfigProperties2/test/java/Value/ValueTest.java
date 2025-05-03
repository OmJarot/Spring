package Value;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        ValueApplication.class
})
public class ValueTest {
    @Autowired
    ValueApplication.SampleValue value;

    @Test
    void testValue() {
        Assertions.assertEquals("Belajar spring boot", value.getName());
        Assertions.assertEquals(1, value.getVersion());
        Assertions.assertEquals(false, value.getProductionMode());
    }
}
