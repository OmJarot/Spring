package Profile.ProfileEnvironment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

@SpringBootTest(classes = {
        ProfileEnvironmentApp.class
})
@ActiveProfiles({
        "local","test","asde","walaer"
})
public class GetActiveTest {
    @Autowired
    ProfileEnvironmentApp.ProfilEnv env;

    @Test
    void testGetActive() {
        List<String> list = Arrays.asList(env.getActive());
        List<String> list1 = Arrays.asList("local", "test", "asde", "walaer");
        Assertions.assertEquals(list,list1);
    }
}
