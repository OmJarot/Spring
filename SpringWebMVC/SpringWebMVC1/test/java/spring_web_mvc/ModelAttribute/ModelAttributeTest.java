package spring_web_mvc.ModelAttribute;

import org.hamcrest.Matchers;
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
public class ModelAttributeTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testModelAttribute() throws Exception {

        mockMvc.perform(
            post("/model")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("firstName", "piter")
                    .param("middleName", "pangaribuan")
                    .param("lastName", "ganteng")
                    .param("email", "piter@test.com")
                    .param("phone", "123")
                    .param("address.street", "jalan jarot")
                    .param("address.city", "batam")
                    .param("address.country", "indonesia")
                    .param("address.postalCode", "321")
                    .param("hobbies[0]","game")
                    .param("hobbies[1]","coding")
                    .param("hobbies[2]","sing")
                    .param("socialMedia[0].name","facebook/piter")
                    .param("socialMedia[0].location","facebook/piter")
                    .param("socialMedia[1].name","instagram/piter")
                    .param("socialMedia[1].location","instagram/piterpng")

        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person piter pangaribuan ganteng" +
                        " With email piter@test.com With phone 123 With address : jalan jarot, batam, indonesia, 321"))
        );

    }
}
