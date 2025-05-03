package spring_web_mvc.ResponseEntity;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ResponseEntityTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testEntity() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","piter")
                        .param("password","rahasia")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK"))
        );
    }

    @Test
    void testKO() throws Exception {
        mockMvc.perform(
                post("/auth/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","salah")
                        .param("password","salah")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("KO"))
        );
    }
}
