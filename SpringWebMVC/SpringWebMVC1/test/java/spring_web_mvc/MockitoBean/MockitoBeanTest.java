package spring_web_mvc.MockitoBean;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import spring_web_mvc.Service.HelloService;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MockitoBeanTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean//membuat object tiruan atau mocking yang otomatis di buat menjadi bean
    HelloService helloService;

    @BeforeEach
    void setUp() {
        Mockito.when(helloService.hello(Mockito.anyString()))//saat memanggil method hello
                .thenReturn("Hello guys");//outputnya selalu hello guys
    }

    @Test
    void testMockitoBean() throws Exception {
        mockMvc.perform(get("/mock")
                        .queryParam("name","piter"))//parameter
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello guys"))
                );
    }
}
