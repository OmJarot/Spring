package spring_web_mvc_test.ResponseEntity;

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
public class EntityTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testEntity() throws Exception {
        mockMvc.perform(
                post("/entity")
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
                post("/entity")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username","salah")
                        .param("password","dsa")
        ).andExpectAll(
                status().isUnauthorized(),
                content().string(Matchers.containsString("KO"))
        );
    }
}
