package spring_web_mvc.Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import Model.CreateAddressRequest;
import Model.CreatePersonRequest;
import Model.CreateSocialMediaRequest;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JsonTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testJson() throws Exception {
        CreatePersonRequest person = CreatePersonRequest.builder()
                .firstName("piter").lastName("pangaribuan").middleName("pangaribuan")
                .email("piter.test@gmail.com").phone("123")
                .hobbies(List.of("game", "coding", "sing"))
                .address(new CreateAddressRequest("Jalan", "batam", "indonesia", "321"))
                .socialMedia(List.of(new CreateSocialMediaRequest("facebook", "fb")))
                .build();

        mockMvc.perform(
                post("/json")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person))
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(person))
        );
    }

}
