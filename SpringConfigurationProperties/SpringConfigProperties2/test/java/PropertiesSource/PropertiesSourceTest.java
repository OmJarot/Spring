package PropertiesSource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
        PropertySourceApplication.class
})
public class PropertiesSourceTest {
    @Autowired
    PropertySourceApplication.SamplePropertySource propertySource;

    @Test
    void testPropertySource() {
        Assertions.assertEquals("Sample project", propertySource.getName());
        Assertions.assertEquals(1, propertySource.getVersion());
    }
}
