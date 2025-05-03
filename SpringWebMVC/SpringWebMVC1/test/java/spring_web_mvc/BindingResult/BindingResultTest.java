package spring_web_mvc.BindingResult;

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
public class BindingResultTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testBindingResultTest() throws Exception {
        mockMvc.perform(
                post("/binding")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .param("middleName","pangaribuan")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid data"))
        );
    }
}
