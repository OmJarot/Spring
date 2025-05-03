package spring_web_mvc_test.Json;

import Model.Address;
import Model.PersonRequest;
import Model.SocialMedia;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class JsonTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testJson() throws Exception {
        PersonRequest person = new PersonRequest();
        person.setFirstName("piter");
        person.setLastName("pangaribuan");
        person.setEmail("piter@Test.com");
        person.setAddress(new Address("batam","indonesia"));
        person.setHobbies(List.of("game","coding"));
        person.setSocialMedia(List.of(new SocialMedia("fb","piterpng")));

        mockMvc.perform(
                post("/json/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person))
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(person))
        );
    }
}
