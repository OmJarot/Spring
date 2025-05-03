package spring_web_mvc_test.Converter;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ConverterTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testConverter() throws Exception {
        mockMvc.perform(
                get("/date")
                        .param("date", "2025-05-20")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("date: 20250520"))
        );
    }
}
