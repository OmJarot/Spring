package resourceLoader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest(classes = {
        ResourceLoaderApplication.class
})
public class ResourceLoaderTest {

    @Autowired
    ResourceLoaderApplication.SampleLoader sampleLoader;

    @Test
    void testResourceLoader() throws IOException {
        Assertions.assertEquals("piter pangaribuan ganteng", sampleLoader.getText());
    }
}
