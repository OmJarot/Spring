package Profile.ProfileEnvironment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
        ProfileApplication.class
})
@ActiveProfiles({
        "local","production","test","asd"
})
public class ProfileEnvironmentTest {
    @Autowired
    ProfileApplication.SampleProfile profile;

    @Test
    void testEnvironment() {
        Assertions.assertArrayEquals(new Object[]{"local","production","test","asd"}, profile.getActive());
    }
}
