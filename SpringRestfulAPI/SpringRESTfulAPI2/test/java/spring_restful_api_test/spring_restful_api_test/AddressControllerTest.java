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
import spring_restful_api_test.spring_restful_api_test.Entity.Address;
import spring_restful_api_test.spring_restful_api_test.Entity.Contact;
import spring_restful_api_test.spring_restful_api_test.Model.AddressRequest;
import spring_restful_api_test.spring_restful_api_test.Model.AddressResponse;
import spring_restful_api_test.spring_restful_api_test.Model.UpdateAddressRequest;
import spring_restful_api_test.spring_restful_api_test.Model.WebResponse;
import spring_restful_api_test.spring_restful_api_test.Repository.AddressRepository;
import spring_restful_api_test.spring_restful_api_test.Repository.ContactRepository;

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
    private AddressRepository addressRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        addressRepository.deleteAll();
    }

    @Test
    void testCreateFailed() throws Exception {
        AddressRequest request = new AddressRequest();
        request.setStreet("dasda");

        mockMvc.perform(
                post("/api/contacts/test/addresses")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
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
    void testCreateAddressNotFound() throws Exception {
        AddressRequest request = new AddressRequest();
        request.setCountry("dasda");

        mockMvc.perform(
                post("/api/contacts/tesfdt/addresses")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
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
    void testCreateAddressSuccess() throws Exception {
        AddressRequest request = new AddressRequest();
        request.setStreet("jalan");
        request.setCity("Batam");
        request.setProvince("kepri");
        request.setCountry("indonesia");
        request.setPostalCode("1223");

        mockMvc.perform(
                post("/api/contacts/test/addresses")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNull(response.getError());
            assertEquals("indonesia",response.getData().getCountry());

            assertTrue(addressRepository.existsById(response.getData().getId()));
        });
    }

    @Test
    void testGetContactNotFound() throws Exception {
        mockMvc.perform(
                get("/api/contacts/test/addresses/salah")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });

            assertNotNull(response.getError());

        });
    }

    @Test
    void testGetContactSuccess() throws Exception {
        Contact contact = contactRepository.findById("test").orElse(null);
        assertNotNull(contact);

        Address request = new Address();
        request.setId("test");
        request.setStreet("jalan");
        request.setCity("Batam");
        request.setProvince("kepri");
        request.setCountry("indonesia");
        request.setPostalCode("1223");
        request.setContactId(contact);
        addressRepository.save(request);

        mockMvc.perform(
                get("/api/contacts/test/addresses/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());

            assertEquals("indonesia", response.getData().getCountry());

        });
    }

    @Test
    void testUpdateFail() throws Exception {
        UpdateAddressRequest request = new UpdateAddressRequest();
        mockMvc.perform(
                put("/api/contacts/test/addresses/tete")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isBadRequest()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getError());
        });

    }

    @Test
    void testUpdateNotFound() throws Exception {
        UpdateAddressRequest request = new UpdateAddressRequest();
        request.setStreet("jalan");
        request.setCity("Batam");
        request.setProvince("kepri");
        request.setCountry("indonesia");
        request.setPostalCode("1223");

        mockMvc.perform(
                put("/api/contacts/test/addresses/tete")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isNotFound()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNotNull(response.getError());
        });
    }

    @Test
    void testUpdateSuccess() throws Exception {
        Contact contact = contactRepository.findById("test").orElse(null);
        assertNotNull(contact);

        Address request = new Address();
        request.setId("test");
        request.setStreet("sumatra");
        request.setCity("btm");
        request.setProvince("kepulauan");
        request.setCountry("indo");
        request.setPostalCode("123223");
        request.setContactId(contact);
        addressRepository.save(request);

        UpdateAddressRequest request1 = new UpdateAddressRequest();
        request1.setStreet("jalan");
        request1.setCity("Batam");
        request1.setProvince("kepri");
        request1.setCountry("indonesia");
        request1.setPostalCode("1223");

        mockMvc.perform(
                put("/api/contacts/test/addresses/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request1))
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<AddressResponse> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());

            assertEquals("jalan", response.getData().getStreet());
            assertEquals("indonesia", response.getData().getCountry());

            Address address = addressRepository.findById(response.getData().getId()).orElse(null);
            assertNotNull(address);

            assertEquals(request1.getCountry(), address.getCountry());
            assertEquals(request1.getStreet(), address.getStreet());
            assertEquals(request1.getCity(), address.getCity());
            assertEquals(request1.getProvince(), address.getProvince());

        });
    }

    @Test
    void testRemoveAddressNotFound() throws Exception {
        mockMvc.perform(
                delete("/api/contacts/test/addresses/rerew")
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
    void testRemoveSuccess() throws Exception {
        Contact contact = contactRepository.findById("test").orElse(null);
        assertNotNull(contact);

        Address request = new Address();
        request.setId("test");
        request.setStreet("sumatra");
        request.setCity("btm");
        request.setProvince("kepulauan");
        request.setCountry("indo");
        request.setPostalCode("123223");
        request.setContactId(contact);
        addressRepository.save(request);

        mockMvc.perform(
                delete("/api/contacts/test/addresses/test")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<String> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<WebResponse<String>>() {
            });
            assertNull(response.getError());
            assertEquals("OK", response.getData());
        });
    }

    @Test
    void testGetAllNotFound() throws Exception {
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

            assertNotNull(response.getError());
        });
    }

    @Test
    void testGetAllSuccess() throws Exception {
        Contact contact = contactRepository.findById("test").orElse(null);
        assertNotNull(contact);

        Address request = new Address();
        request.setId("test");
        request.setStreet("sumatra");
        request.setCity("btm");
        request.setProvince("kepulauan");
        request.setCountry("indo");
        request.setPostalCode("123223");
        request.setContactId(contact);
        addressRepository.save(request);

        mockMvc.perform(
                get("/api/contacts/test/addresses")
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-API-TOKEN", "test")
        ).andExpectAll(
                status().isOk()
        ).andDo(result -> {
            WebResponse<List<AddressResponse>> response = objectMapper.readValue(result.getResponse().getContentAsString(), new TypeReference<>() {
            });
            assertNull(response.getError());
            assertEquals(1, response.getData().size());
        });

    }
}
