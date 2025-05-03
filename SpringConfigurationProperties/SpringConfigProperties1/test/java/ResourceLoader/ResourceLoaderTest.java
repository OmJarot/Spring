package ResourceLoader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest(classes = {
        ResourceApplication.class
})
public class ResourceLoaderTest {

    @Autowired
    SampleResource resource;

    @Autowired
    ApplicationContext context;

    @Test
    void testLoader() throws IOException {//menggunakan ResourceLoaderAware
        Assertions.assertEquals("Piter pangaribuan ganteng", resource.getText().trim());
    }

    @Test
    void testContext() throws IOException {//menggunakan application context
        Resource resource = context.getResource("classpath:/text/resource.txt");
        InputStream inputStream = resource.getInputStream();
        System.out.println(new String(inputStream.readAllBytes()));
    }
}
