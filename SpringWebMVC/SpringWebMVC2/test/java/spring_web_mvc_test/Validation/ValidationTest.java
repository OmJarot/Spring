package spring_web_mvc_test.Validation;

import Model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class ValidationTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testInvalid() throws Exception {
        Person person = new Person();
        person.setId("ds");

        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person))
        ).andExpectAll(
                status().isBadRequest()
        );
    }

    @Test
    void testValidation() throws Exception {
        Person person = new Person("1","piter");

        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person))
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(person))
        );
    }

    @Test
    void testForm() throws Exception {
        mockMvc.perform(
                post("/form/valid")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("id","1")
        ).andExpectAll(
                status().isBadRequest()
        );
    }
}
