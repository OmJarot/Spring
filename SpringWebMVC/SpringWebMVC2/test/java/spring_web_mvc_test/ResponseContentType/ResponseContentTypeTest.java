package spring_web_mvc_test.ResponseContentType;

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
public class ResponseContentTypeTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testResponse() throws Exception {
        mockMvc.perform(
                post("/html")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .accept(MediaType.TEXT_HTML_VALUE)
                        .param("name","piter")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello piter"))
        );
    }
}
