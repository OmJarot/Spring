package spring_web_mvc.Validation;

import Model.CreatePersonRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testValidation() throws Exception {
        CreatePersonRequest person = CreatePersonRequest.builder().middleName("pangaribuan").build();
        String json = objectMapper.writeValueAsString(person);

        mockMvc.perform(
                post("/valid/json")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json)
        ).andExpectAll(
                status().isBadRequest()//mengembalikan status 400, karena tidak valid
        );
    }

    @Test
    void testValidationForm() throws Exception {
        mockMvc.perform(
                post("/valid/form")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("lastName","ganteng")
        ).andExpectAll(
                status().isBadRequest()
        );
    }
}
