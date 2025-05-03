package spring_web_mvc.Session;

import Model.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SessionTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testSession() throws Exception {
        mockMvc.perform(
                get("/user/current")
                        .sessionAttr("user", new User("piter"))
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello piter"))
        );
    }

    @Test
    void testLog() throws Exception {
        mockMvc.perform(
                post("/login/session")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","piter")
                        .param("password", "rahasia")
        ).andExpectAll(
                status().isOk()
        );
    }
}
