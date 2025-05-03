package spring_restful_api_test.spring_restful_api_test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.LoginRequest;
import spring_restful_api_test.spring_restful_api_test.Model.TokenResponse;
import spring_restful_api_test.spring_restful_api_test.Model.WebResponse;
import spring_restful_api_test.spring_restful_api_test.Repository.UserRepository;
import spring_restful_api_test.spring_restful_api_test.Security.BCrypt;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();

        User user = new User();
        user.setUsername("piter");
        user.setName("piter");
        user.setPassword(BCrypt.hashpw("piter", BCrypt.gensalt()));
        user.setToken("test");
        user.setTokenExpiredAt(System.currentTimeMillis() + 3213217831287L);

        userRepository.save(user);
    }

    @Test
    void testLoginFailedNull() throws Exception {
        LoginRequest loginRequest = new LoginRequest();

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testLoginFailed() throws Exception {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("das");
        loginRequest.setPassword("dsaas");

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest))
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testLoginSuccess() throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("piter");
        loginRequest.setPassword("piter");

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<TokenResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());
            assertNotNull(response.getData().getToken());
            assertNotNull(response.getData().getExpiredAt());

            User user = userRepository.findById("piter").orElse(null);
            assertNotNull(user);

            assertEquals(response.getData().getToken(), user.getToken());
            assertEquals(response.getData().getExpiredAt(), user.getTokenExpiredAt());
        });
    }

    @Test
    void testLogout() throws Exception {
        mockMvc.perform(
                delete("/api/auth/logout")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getError());
            assertEquals("OK", response.getData());

            User user = userRepository.findById("piter").orElse(null);
            assertNotNull(user);
            assertNull(user.getToken());
            assertNull(user.getTokenExpiredAt());
        });
    }
}
