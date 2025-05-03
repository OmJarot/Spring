package spring_web_mvc_test.MockMVC;

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
public class MockMVCTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testMockMvc() throws Exception {
        mockMvc.perform(
                get("/reqres")
                        .param("name", "piter")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello piter"))
        );
    }

    @Test
    void testGuest() throws Exception {
        mockMvc.perform(
                get("/reqres")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("hello guest"))
        );
    }
}
