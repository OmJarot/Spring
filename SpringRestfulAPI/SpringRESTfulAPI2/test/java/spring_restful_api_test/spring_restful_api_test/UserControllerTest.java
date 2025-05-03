package spring_restful_api_test.spring_restful_api_test;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import spring_restful_api_test.spring_restful_api_test.Model.RegisterUserRequest;
import spring_restful_api_test.spring_restful_api_test.Model.UserResponse;
import spring_restful_api_test.spring_restful_api_test.Model.UserUpdateRequest;
import spring_restful_api_test.spring_restful_api_test.Model.WebResponse;
import spring_restful_api_test.spring_restful_api_test.Repository.UserRepository;
import spring_restful_api_test.spring_restful_api_test.Security.BCrypt;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

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
    void testRegister() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("piter");
        request.setPassword("rahasia");
        request.setName("piter pangaribuan");

        mockMvc.perform(
                post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertEquals("OK", response.getData());
        });
    }

    @Test
    void testRegisterFailed() throws Exception {
        RegisterUserRequest request = new RegisterUserRequest();

        mockMvc.perform(
                post("/api/users")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getError());
        });
    }

    @Test
    void testRegisterExist() throws Exception {
        User user = new User();
        user.setName("piter");
        user.setUsername("piter");
        user.setPassword("piter");
        userRepository.save(user);

        RegisterUserRequest request = new RegisterUserRequest();
        request.setUsername("piter");
        request.setPassword("rahasia");
        request.setName("piter pangaribuan");

        mockMvc.perform(
                post("/api/users")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getError());
        });
    }

    @Test
    void testGetFailed() throws Exception {
        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-Token","ds")
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getError());
        });
    }

    @Test
    void testGetSuccess() throws Exception {
        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN","test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getError());
            assertNotNull(response.getData().getName());
            assertNotNull(response.getData().getPassword());

            User user = userRepository.findFirstByToken("test").orElse(null);
            assertNotNull(user);

            assertEquals(response.getData().getName(), user.getUsername());
            assertEquals(response.getData().getPassword(), user.getPassword());
        });
    }

    @Test
    void testUpdateFailed() throws Exception {
        mockMvc.perform(
                patch("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "dsa")
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getError());
        });
    }

    @Test
    void testUpdateSuccess() throws Exception {
        UserUpdateRequest request = new UserUpdateRequest();
        request.setName("piternew");
        request.setPassword("piternew");

        mockMvc.perform(
                patch("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getError());
            assertEquals("piternew", response.getData().getName());
            assertTrue(BCrypt.checkpw("piternew", response.getData().getPassword()));

        });
    }
}
