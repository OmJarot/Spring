package spring_web_mvc.ErrorHandler;

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
public class ErrorHandlerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testErrorHandler() throws Exception {
        mockMvc.perform(
                post("/valid/form")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName","aasd")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("Validation Error"))
        );
    }
}
