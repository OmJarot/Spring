package spring_web_mvc_test.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testRestController() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("todo", "coding");
        params.add("todo", "game");
        params.add("todo", "sing");

        mockMvc.perform(
                post("/todos")
                        .accept(MediaType.APPLICATION_JSON)
                        .params(params)
        ).andExpectAll(
                status().isOk()
        );

        List<String> expect = List.of("coding", "game", "sing");

        mockMvc.perform(
                get("/todos")
                        .accept(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(expect))
        );
    }

    @Test
    void testGet() throws Exception {
//        List<String> expect = List.of("coding", "game", "sing");
//
//        mockMvc.perform(
//                get("/todos")
//                        .accept(MediaType.APPLICATION_JSON)
//        ).andExpectAll(
//                status().isOk(),
//                content().json(objectMapper.writeValueAsString(expect))
//        );
    }
}
