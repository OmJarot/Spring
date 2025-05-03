package spring_web_mvc.RequestMethod;

import org.junit.jupiter.api.AfterEach;
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
public class RequestMethodTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    HelloService helloService;

    @AfterEach
    void tearDown() {
        Mockito.when(helloService.hello(Mockito.anyString()))
                .thenReturn("Hello guys");
    }

    @Test
    void testRequestMethod() throws Exception {
        mockMvc.perform(post("/req").queryParam("name","piter"))//request menggunakan post
                .andExpectAll(
                        status().isMethodNotAllowed()//hasilnya adalag 405 method not allowed
                );
    }
}
