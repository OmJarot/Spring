package spring_restful_api;

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
import spring_restful_api.Entity.Address;
import spring_restful_api.Entity.Contact;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.*;
import spring_restful_api.Repository.AddressRepository;
import spring_restful_api.Repository.ContactRepository;
import spring_restful_api.Repository.UserRepository;
import spring_restful_api.Security.BCrypt;

import java.util.List;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ObjectMapper objectMapper;

    User user;
    Contact contact;

    @BeforeEach
    void setUp() {
        addressRepository.deleteAll();
        contactRepository.deleteAll();

        user = userRepository.findById("test").orElseThrow(() -> new RuntimeException("err"));

        contact = new Contact();
        contact.setUser(user);
        contact.setId("test");
        contact.setFirstName("contact");
        contact.setLastName("test");
        contact.setEmail("contact@test.com");
        contact.setPhone("1232");
        contactRepository.save(contact);

        assertTrue(contactRepository.existsById("test"));
    }

    @Test
    void testCreateAddressBadRequest() throws Exception {
        CreateAddressRequest request = new CreateAddressRequest();
        request.setCountry("");

        mockMvc.perform(
                post("/api/contacts/test/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testCreateAddressSuccess() throws Exception {
        CreateAddressRequest request = new CreateAddressRequest();
        request.setStreet("cemara");
        request.setCity("batam");
        request.setProvince("kepri");
        request.setCountry("indo");
        request.setPostCode("123");

        mockMvc.perform(
                post("/api/contacts/test/addresses")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals("cemara", response.getData().getStreet());
            assertEquals("batam", response.getData().getCity());
            assertEquals("kepri", response.getData().getProvince());
            assertEquals("indo", response.getData().getCountry());
            assertEquals("123", response.getData().getPostCode());

            assertTrue(addressRepository.existsById(response.getData().getId()));
        });
    }

    @Test
    void testGetAddressNotFound() throws Exception {
        mockMvc.perform(
                get("/api/contacts/test/addresses/dadas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testGetAddressSuccess() throws Exception {
        Address address = new Address();
        address.setId("test");
        address.setContact(contact);
        address.setCity("batam");
        address.setProvince("kepri");
        address.setCountry("indo");
        address.setStreet("test");
        address.setPostalCode("123");

        addressRepository.save(address);

        mockMvc.perform(
                get("/api/contacts/test/addresses/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<AddressResponse>>() {
            });
            assertNull(response.getErrors());
            assertEquals("test", response.getData().getId());
            assertEquals("batam", response.getData().getCity());
            assertEquals("123", response.getData().getPostCode());
            assertEquals("test", response.getData().getStreet());
            assertEquals("indo", response.getData().getCountry());
            assertEquals("kepri", response.getData().getProvince());
        });
    }

    @Test
    void testUpdateBadRequest() throws Exception {
        Address address = new Address();
        address.setId("test");
        address.setContact(contact);
        address.setCity("batam");
        address.setProvince("kepri");
        address.setCountry("indo");
        address.setStreet("test");
        address.setPostalCode("123");

        addressRepository.save(address);

        UpdateAddressRequest request = new UpdateAddressRequest();
        request.setCountry("");

        mockMvc.perform(
                put("/api/contacts/test/addresses/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testUpdateAddressSuccess() throws Exception {
        Address address = new Address();
        address.setId("test");
        address.setContact(contact);
        address.setCity("batam");
        address.setProvince("kepri");
        address.setCountry("indo");
        address.setStreet("test");
        address.setPostalCode("123");

        addressRepository.save(address);

        UpdateAddressRequest request = new UpdateAddressRequest();
        request.setStreet("cemara");
        request.setCity("batam");
        request.setProvince("kepulauan riau");
        request.setCountry("indonesia");
        request.setPostCode("1234");

        mockMvc.perform(
                put("/api/contacts/test/addresses/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals("cemara", response.getData().getStreet());
            assertEquals("batam", response.getData().getCity());
            assertEquals("kepulauan riau", response.getData().getProvince());
            assertEquals("indonesia", response.getData().getCountry());
            assertEquals("1234", response.getData().getPostCode());

            assertTrue(addressRepository.existsById(response.getData().getId()));
        });
    }

    @Test
    void testDeleteAddressNotFound() throws Exception {
        mockMvc.perform(
                delete("/api/contacts/test/addresses/dadas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testDeleteAddressSuccess() throws Exception {
        Address address = new Address();
        address.setId("test");
        address.setContact(contact);
        address.setCity("batam");
        address.setProvince("kepri");
        address.setCountry("indo");
        address.setStreet("test");
        address.setPostalCode("123");

        addressRepository.save(address);

        mockMvc.perform(
                delete("/api/contacts/test/addresses/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNull(response.getErrors());
            assertEquals("OK", response.getData());
            assertFalse(addressRepository.existsById("test"));
        });
    }

    @Test
    void testListAddressNotFound() throws Exception {
        mockMvc.perform(
                get("/api/contacts/dasda/addresses")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(
                    result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getErrors());
        });
    }

    @Test
    void testListAddressSuccess() throws Exception {
        for (int i = 0; i < 5; i++) {
            Address address = new Address();
            address.setId("test"+i);
            address.setContact(contact);
            address.setCity("batam");
            address.setProvince("kepri");
            address.setCountry("indo");
            address.setStreet("test");
            address.setPostalCode("123");

            addressRepository.save(address);
        }

        mockMvc.perform(
                get("/api/contacts/test/addresses")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<AddressResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getErrors());
            assertEquals(5, response.getData().size());
        });
    }
}
