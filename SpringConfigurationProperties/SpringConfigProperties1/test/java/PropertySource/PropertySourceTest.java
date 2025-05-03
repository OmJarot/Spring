package PropertySource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;

@SpringBootTest(classes = {
        SampleSpring.class
})
public class PropertySourceTest {
    @Autowired
    SamplePropertySource propertySource;

    @Test
    void testPropertySource() {
        Assertions.assertEquals("Sample project",propertySource.getName());
        Assertions.assertEquals(1,propertySource.getVersion());
    }
}
