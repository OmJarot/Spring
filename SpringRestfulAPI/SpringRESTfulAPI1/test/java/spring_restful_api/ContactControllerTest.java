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
import spring_restful_api.Entity.Contact;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.ContactResponse;
import spring_restful_api.Model.CreateContactRequest;
import spring_restful_api.Model.UpdateContactRequest;
import spring_restful_api.Model.WebResponse;
import spring_restful_api.Repository.ContactRepository;
import spring_restful_api.Repository.UserRepository;
import spring_restful_api.Security.BCrypt;

import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

    User user = new User();

    @BeforeEach
    void setUp() {
        contactRepository.deleteAll();
        userRepository.deleteAll();

        user.setUsername("test");
        user.setPassword(BCrypt.hashpw("test", BCrypt.gensalt()));
        user.setName("test");
        user.setToken("test");
        user.setTokenExpiredAt(System.currentTimeMillis()+32133123L);
        userRepository.save(user);
    }

    @Test
    void testCreateContactBadRequest() throws Exception {
        CreateContactRequest request = new CreateContactRequest();
        request.setFirstName("");
        request.setEmail("salah");

        mockMvc.perform(
                post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", user.getToken())
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
    void testCreateContactSuccess() throws Exception {
        CreateContactRequest request = new CreateContactRequest();
        request.setFirstName("piter");
        request.setLastName("pangaribuan");
        request.setEmail("piter@gmail.com");
        request.setPhone("123321");

        mockMvc.perform(
                post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
            });

            assertNull(response.getErrors());
            assertEquals("piter", response.getData().getFirstName());
            assertEquals("pangaribuan", response.getData().getLastName());

            assertTrue(contactRepository.existsById(response.getData().getId()));
        });
    }

    @Test
    void testGetContactFailed() throws Exception {
        mockMvc.perform(
                get("/api/contacts/dada")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testGetContactSuccess() throws Exception {
        User user1 = userRepository.findById("test").orElse(null);
        assertNotNull(user1);

        Contact contact = new Contact();
        contact.setId("testContact");
        contact.setFirstName("asd");
        contact.setUser(user1);
        contactRepository.save(contact);

        mockMvc.perform(
                get("/api/contacts/"+contact.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals("testContact", response.getData().getId());
            assertEquals("asd", response.getData().getFirstName());
        });
    }

    @Test
    void testUpdateBadRequest() throws Exception {
        UpdateContactRequest request = new UpdateContactRequest();
        request.setFirstName("");
        request.setEmail("salah");

        mockMvc.perform(
                put("/api/contacts/3213")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", user.getToken())
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testUpdateContactSuccess() throws Exception {
        User user1 = userRepository.findById("test").orElse(null);
        assertNotNull(user1);

        Contact contact = new Contact();
        contact.setId("testContact");
        contact.setFirstName("asd");
        contact.setUser(user1);
        contactRepository.save(contact);

        UpdateContactRequest request = new UpdateContactRequest();
        request.setFirstName("contact test");
        request.setLastName("last test");
        request.setEmail("dsa@dsa.das");
        request.setPhone("3213");

        mockMvc.perform(
                put("/api/contacts/"+contact.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals("contact test", response.getData().getFirstName());
            assertEquals("last test", response.getData().getLastName());
            assertEquals("dsa@dsa.das", response.getData().getEmail());
            assertEquals("3213", response.getData().getPhone());
        });
    }

    @Test
    void testDeleteContactNotFound() throws Exception {
        mockMvc.perform(
                delete("/api/contacts/salah")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testDeleteContactSuccess() throws Exception {
        User user1 = userRepository.findById("test").orElse(null);
        assertNotNull(user1);

        Contact contact = new Contact();
        contact.setId("testContact");
        contact.setFirstName("asd");
        contact.setUser(user1);
        contactRepository.save(contact);

        mockMvc.perform(
                delete("/api/contacts/"+contact.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals("OK", response.getData());
        });
    }

    @Test
    void testSearchNotFound() throws Exception {
        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(responses);
            assertEquals(0, responses.getData().size());
            assertEquals(0,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());

        });
    }

    @Test
    void testSearchName() throws Exception {
        User user1 = userRepository.findById("test").orElse(null);
        assertNotNull(user1);

        for (int i = 0; i < 100; i++) {
            Contact contact = new Contact();
            contact.setId(UUID.randomUUID().toString());
            contact.setFirstName("Piter "+i);
            contact.setLastName("Pangaribuan");
            contact.setEmail("email@d.com");
            contact.setPhone("123");
            contact.setUser(user1);

            contactRepository.save(contact);
        }

        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .param("name", "Piter")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(responses);
            assertEquals(10, responses.getData().size());
            assertEquals(10,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());

        });

        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .param("name", "Pangaribuan")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(responses);
            assertEquals(10, responses.getData().size());
            assertEquals(10,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());

        });

        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .param("email", "d.com")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(responses);
            assertEquals(10, responses.getData().size());
            assertEquals(10,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());

        });

        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .param("phone", "23")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(responses);
            assertEquals(10, responses.getData().size());
            assertEquals(10,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());

        });

        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .param("page", "1000")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(responses);
            assertEquals(0, responses.getData().size());
            assertEquals(10,responses.getPaging().getTotalPage());
            assertEquals(1000,responses.getPaging().getCurrentPage());//page sekarang
            assertEquals(10, responses.getPaging().getSize());

        });
    }
}
