package spring_restful_api;

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
import spring_restful_api.Entity.User;
import spring_restful_api.Model.RegisterUserRequest;
import spring_restful_api.Model.UserResponse;
import spring_restful_api.Model.UserUpdateRequest;
import spring_restful_api.Model.WebResponse;
import spring_restful_api.Repository.UserRepository;
import spring_restful_api.Security.BCrypt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    }

    @Test
    void testRegisterSuccess() throws Exception {
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
        request.setUsername("");
        request.setPassword("");
        request.setName("");

        mockMvc.perform(
                post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testRegisterDuplicate() throws Exception {
        User user = new User();
        user.setUsername("piter");
        user.setPassword("rahasia");
        user.setName("piter pangaribuan");
        userRepository.save(user);

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
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testUnauthorizedWrongToken() throws Exception {
        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "dasdas")
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testUnauthorizedTokenNotSend() throws Exception {
        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testGetUserSuccess() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setName("test");
        user.setToken("test");
        user.setTokenExpiredAt(System.currentTimeMillis()+321312313123L);
        userRepository.save(user);

        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN","test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<UserResponse>>() {
            });

            assertNotNull(response);
            assertEquals("test", response.getData().getUsername());
            assertEquals("test", response.getData().getPassword());
        });
    }

    @Test
    void testGetUserTokenExpired() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setName("test");
        user.setToken("test");
        user.setTokenExpiredAt(System.currentTimeMillis()-32133123L);
        userRepository.save(user);

        mockMvc.perform(
                get("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN","test")
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<UserResponse>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testUpdateUnauthorized() throws Exception {
        mockMvc.perform(
                patch("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<UserResponse>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testUpdateSuccess() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setName("test");
        user.setToken("test");
        user.setTokenExpiredAt(System.currentTimeMillis()+32133123L);
        userRepository.save(user);

        UserUpdateRequest request = new UserUpdateRequest();
        request.setName("testo");
        request.setPassword("testo");

        mockMvc.perform(
                patch("/api/users/current")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<UserResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals("testo", response.getData().getUsername());
            assertTrue(BCrypt.checkpw("testo", response.getData().getPassword()));

            User user1 = userRepository.findFirstByToken("test").orElse(null);
            assertNotNull(user1);
        });
    }
}
