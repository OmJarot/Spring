package ProfilePropertiesFile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        ProfilePropertiesFileApp.class
})
@ActiveProfiles({
        "production","test"
})
public class ProfilePropertiesFileTest {
    @Autowired
    ProfilePropertiesFileApp.SampleProfileFile file;

    @Test
    void testPropertiesFile() {
        Assertions.assertEquals("default", file.getDefaultFile());
        Assertions.assertEquals("production", file.getProductionFile());
        Assertions.assertEquals("test", file.getTestFile());
    }
}
