package spring_web_mvc.FormRequest;

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
public class FormRequestTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testFormRequest() throws Exception {
        mockMvc.perform(
                post("/registrasi")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name","piter")
                        .param("birthDate","2005-05-02")
                        .param("address","blok i")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person with name: piter" +
                        ", birthDate: 2005-05-02" +
                        ", address: blok i" ))
        );
    }
}
