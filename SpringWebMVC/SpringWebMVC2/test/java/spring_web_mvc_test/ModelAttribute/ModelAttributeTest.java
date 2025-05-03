package spring_web_mvc_test.ModelAttribute;

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
public class ModelAttributeTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testModelAttribute() throws Exception {
        mockMvc.perform(
                post("/model")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "piter")
                        .param("lastName", "pangaribuan")
                        .param("email", "piter@test.com")
                        .param("address.city", "batam")
                        .param("address.country", "indonesia")
                        .param("hobbies[0]", "game")
                        .param("hobbies[1]", "coding")
                        .param("socialMedia[0].socialMedia", "fb")
                        .param("socialMedia[0].username", "piter")
                        .param("socialMedia[1].socialMedia", "ig")
                        .param("socialMedia[1].username", "pangaribuan")
        ).andExpectAll(
                status().isOk()
        );
    }
}
