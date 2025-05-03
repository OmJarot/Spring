package spring_restful_api_test.spring_restful_api_test.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.AddressRequest;
import spring_restful_api_test.spring_restful_api_test.Model.AddressResponse;
import spring_restful_api_test.spring_restful_api_test.Model.UpdateAddressRequest;
import spring_restful_api_test.spring_restful_api_test.Model.WebResponse;
import spring_restful_api_test.spring_restful_api_test.Service.AddressService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AddressController {

    private AddressService addressService;

    @PostMapping(
            path = "/api/contacts/{idContact}/addresses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(User user, @RequestBody AddressRequest request, @PathVariable("idContact") String idContact){
        request.setIdContact(idContact);
        AddressResponse response = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder()
                .data(response)
                .build();
    }

    @GetMapping(path = "/api/contacts/{idContact}/addresses/{idAddress}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<AddressResponse> getCurrent(User user, @PathVariable("idContact") String idContact, @PathVariable("idAddress")String idAddress){
        AddressResponse address = addressService.getAddress(user, idContact, idAddress);
        return WebResponse.<AddressResponse>builder().data(address).build();
    }

    @PutMapping(path = "/api/contacts/{idContact}/addresses/{idAddress}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<AddressResponse> update(
            User user,
            @PathVariable("idContact") String idContact,
            @PathVariable("idAddress")String idAddress,
            @RequestBody UpdateAddressRequest request){

        request.setIdContact(idContact);
        request.setIdAddress(idAddress);

        AddressResponse update = addressService.update(user, request);
        return WebResponse.<AddressResponse>builder().data(update).build();
    }

    @DeleteMapping(path = "/api/contacts/{idContact}/addresses/{idAddress}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> deleteAddress(User user,
                                             @PathVariable("idContact") String idContact,
                                             @PathVariable("idAddress") String idAddress){

        addressService.remove(user, idContact, idAddress);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(value = "/api/contacts/{idContact}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<AddressResponse>> getAll(User user, @PathVariable("idContact") String idContact) {
        List<AddressResponse> all = addressService.getAll(user, idContact);
        return WebResponse.<List<AddressResponse>>builder().data(all).build();
    }

}
