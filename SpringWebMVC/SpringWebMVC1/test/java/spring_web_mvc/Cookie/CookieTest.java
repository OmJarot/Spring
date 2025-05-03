package spring_web_mvc.Cookie;

import jakarta.servlet.http.Cookie;
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
public class CookieTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testCookie() throws Exception {
        mockMvc.perform(
                post("/cookie")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","piter")
                        .param("password","rahasia")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK")),
                cookie().value("username", Matchers.is("piter"))
        );
    }

    @Test
    void testCookies() throws Exception {
        mockMvc.perform(
                get("/cookie/home")
                        .cookie(new Cookie("username","piter"))
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello piter"))
        );
    }
}
