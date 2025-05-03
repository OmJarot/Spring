package spring_web_mvc.RequestBody;

import Model.HelloRequest;
import Model.HelloResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
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
public class RequestBodyTest {
    
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testRequestBody() throws Exception {
        HelloRequest helloRequest = new HelloRequest();
        helloRequest.setName("piter");

        mockMvc.perform(
                post("/body/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(helloRequest))//kirim data json
        ).andExpectAll(
                status().isOk()
        ).andExpect(result -> {
            String responseBody = result.getResponse().getContentAsString();//ambil body jsonnya
            HelloResponse response = objectMapper.readValue(responseBody, HelloResponse.class);
            Assertions.assertEquals("Hello piter", response.getHello());
        });
    }
}
