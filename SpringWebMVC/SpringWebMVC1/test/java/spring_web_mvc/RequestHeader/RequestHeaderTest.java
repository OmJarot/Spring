package spring_web_mvc.RequestHeader;

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
public class RequestHeaderTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testRequestHeader() throws Exception {
        mockMvc.perform(
                get("/header/token")
                        .header("X-TOKEN","PITER")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OK"))
        );
    }

    @Test
    void testKO() throws Exception {
        mockMvc.perform(
                get("/header/token")
                        .header("X-TOKEN", "salah")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("KO"))
        );
    }
}
