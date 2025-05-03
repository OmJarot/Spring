package spring_web_mvc.MockMVC;

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
@AutoConfigureMockMvc//agar bisa meng-inject mock mvc
public class MockMVCTest {
    //test controller tanpa menjalankan aplikasi webnya

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGuest() throws Exception {
        mockMvc.perform(get("/reqresp"))//ambil path webnya
                .andExpectAll(
                        status().isOk(),//cek statusnya ok
                        content().string(Matchers.containsString("Hello guest"))//cek outputnya
                );
    }

    @Test
    void testHelloName() throws Exception {
        mockMvc.perform(
                get("/reqresp")
                        .queryParam("name","piter")//set query parameter
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello piter"))//cek outputnya
        );
    }
}
