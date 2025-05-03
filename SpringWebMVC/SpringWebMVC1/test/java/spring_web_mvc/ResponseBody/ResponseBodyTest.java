package spring_web_mvc.ResponseBody;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ResponseBodyTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void testResponseBody() throws Exception {
        mockMvc.perform(get("/sayHello").queryParam("name","piter"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("hello piter"))
                );
    }
}
