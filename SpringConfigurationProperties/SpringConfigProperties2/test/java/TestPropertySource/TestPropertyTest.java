package TestPropertySource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@SpringBootTest(classes = {
        TestPropertySourceApp.class
})
@TestPropertySources({
        @TestPropertySource("classpath:/test.properties")
})
public class TestPropertyTest {
    @Autowired
    TestPropertySourceApp.SamplePropertyTest property;

    @Test
    void testPropertyTest() {
        Assertions.assertEquals("test", property.getName());
        Assertions.assertEquals(1, property.getVersion());
    }
}
