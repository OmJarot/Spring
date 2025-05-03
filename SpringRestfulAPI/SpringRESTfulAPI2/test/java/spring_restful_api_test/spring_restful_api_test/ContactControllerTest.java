package spring_restful_api_test.spring_restful_api_test;
import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring_restful_api_test.spring_restful_api_test.Entity.Contact;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.*;
import spring_restful_api_test.spring_restful_api_test.Repository.ContactRepository;
import spring_restful_api_test.spring_restful_api_test.Repository.UserRepository;

import java.util.List;

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

    private User user;

    @BeforeEach
    void setUp() {
        user = userRepository.findById("piter").orElse(null);
        assertNotNull(user);

        contactRepository.deleteAll();
        Contact contact = new Contact();
        contact.setUser(user);
        contact.setId("test");
        contact.setFirstName("piter");
        contact.setLastName("png");
        contact.setEmail("piter@test.com");
        contact.setPhone("123");
        contactRepository.save(contact);


    }

    @Test
    void testCreateContactFail() throws Exception {
        ContactRequest request = new ContactRequest();
        request.setLastName("png");

        mockMvc.perform(
                post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testCreateContactSuccess() throws Exception{
        ContactRequest request = new ContactRequest();
        request.setFirstName("piter");
        request.setLastName("png");
        request.setEmail("piter@test.com");
        request.setPhone("123");

        mockMvc.perform(
                post("/api/contacts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());
            assertNotNull(response.getData().getId());
            assertEquals(request.getFirstName(), response.getData().getFirstName());
            assertEquals(request.getLastName(), response.getData().getLastName());
            assertEquals(request.getEmail(), response.getData().getEmail());
            assertEquals(request.getPhone(), response.getData().getPhone());

            assertTrue(contactRepository.existsById(response.getData().getId()));
        });
    }

    @Test
    void testGetContactNotFound() throws Exception {
        mockMvc.perform(
                get("/api/contacts/123")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testGetContactSuccess() throws Exception {
        mockMvc.perform(
                get("/api/contacts/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());
            assertEquals("test", response.getData().getId());
            assertEquals("piter", response.getData().getFirstName());
            assertEquals("png", response.getData().getLastName());
        });
    }

    @Test
    void testUpdateContactFailed() throws Exception {
        UpdateContactRequest request = new UpdateContactRequest();
        request.setFirstName("piter");
        request.setLastName("png");
        request.setEmail("piter@test.com");
        request.setPhone("123");

        mockMvc.perform(
                put("/api/contacts/3213")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testUpdateContactUnauthorized() throws Exception {
        UpdateContactRequest request = new UpdateContactRequest();
        request.setFirstName("piter");
        request.setLastName("png");
        request.setEmail("piter@test.com");
        request.setPhone("123");

        mockMvc.perform(
                put("/api/contacts/3213")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "salah")
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isUnauthorized()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testUpdateContactBadRequest() throws Exception {
        UpdateContactRequest request = new UpdateContactRequest();
        request.setFirstName("");
        request.setLastName("png");
        request.setEmail("piter@test.com");
        request.setPhone("123");

        mockMvc.perform(
                put("/api/contacts/3213")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testUpdateContactSuccess() throws Exception {
        UpdateContactRequest request = new UpdateContactRequest();
        request.setFirstName("piter new");
        request.setLastName("png");
        request.setEmail("piter@new.com");
        request.setPhone("12345");

        mockMvc.perform(
                put("/api/contacts/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<ContactResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<ContactResponse>>() {
            });
            assertNull(response.getError());
            assertEquals(request.getFirstName(), response.getData().getFirstName());

            Contact contact = contactRepository.findById("test").orElse(null);
            assertNotNull(contact);
            assertEquals(request.getFirstName(), contact.getFirstName());
        });
    }

    @Test
    void testDeleteNotFound() throws Exception {
        mockMvc.perform(
                delete("/api/contacts/salah")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testDeleteSuccess() throws Exception {
        mockMvc.perform(
                delete("/api/contacts/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNull(response.getError());
            assertEquals("OK", response.getData());

            assertFalse(contactRepository.existsById("test"));
        });
    }

    @Test
    void testSearch() throws Exception {
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
            assertEquals(1, responses.getData().size());
            assertEquals(1,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());
        });
    }

    @Test
    void testSearchAll() throws Exception {
        mockMvc.perform(
                get("/api/contacts")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
                        .param("name","piter")
                        .param("email", "piter@test.com")
                        .param("phone","123")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<ContactResponse>> responses = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(responses);
            assertEquals(1, responses.getData().size());
            assertEquals(1,responses.getPaging().getTotalPage());
            assertEquals(0,responses.getPaging().getCurrentPage());
            assertEquals(10, responses.getPaging().getSize());
        });
    }
}
