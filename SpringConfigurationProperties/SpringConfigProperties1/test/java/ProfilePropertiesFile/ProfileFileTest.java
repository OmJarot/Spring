package ProfilePropertiesFile;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        ProfileFileApplication.class
})
@ActiveProfiles({
        "production","test"
})
public class ProfileFileTest {

    @Autowired
    ProfileFileApplication.ProfileProperties profile;

    @Test
    void testProfileFile() {
        Assertions.assertEquals("default", profile.getDefaultFile());
        Assertions.assertEquals("production", profile.getProductionFile());
        Assertions.assertEquals("test", profile.getTestFile());
    }
}
