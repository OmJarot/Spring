package resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {
    @Test
    void testResource() throws IOException {
        ClassPathResource resource = new ClassPathResource("/text/sample.txt");

        Assertions.assertNotNull(resource);
        Assertions.assertNotNull(resource.getFile());
        Assertions.assertTrue(resource.exists());
    }
}
