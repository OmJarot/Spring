package spring_web_mvc.RestController;

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
public class RestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testAddTodo() throws Exception {
        mockMvc.perform(
                post("/todos")
                        .accept(MediaType.APPLICATION_JSON)
                        .param("todo","piter")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("piter"))
        );
    }

    @Test
    void testGetTodo() throws Exception {
        mockMvc.perform(
                get("/todos")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("piter"))
        );
    }
}
