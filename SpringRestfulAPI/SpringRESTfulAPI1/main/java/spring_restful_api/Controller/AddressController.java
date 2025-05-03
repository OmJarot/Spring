package spring_restful_api.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.AddressResponse;
import spring_restful_api.Model.CreateAddressRequest;
import spring_restful_api.Model.UpdateAddressRequest;
import spring_restful_api.Model.WebResponse;
import spring_restful_api.Service.AddressService;

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
    public WebResponse<AddressResponse> create(User user,
                                               @RequestBody CreateAddressRequest request,
                                               @PathVariable("idContact") String id){
        request.setId(id);
        AddressResponse response = addressService.create(user, request);

        return WebResponse.<AddressResponse>builder().data(response).build();
    }

    @GetMapping(path = "/api/contacts/{idContact}/addresses/{idAddress}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> get(User user,
                                            @PathVariable("idContact") String contactId,
                                            @PathVariable("idAddress") String addressId){
        AddressResponse response = addressService.get(user, contactId, addressId);
        return WebResponse.<AddressResponse>builder().data(response).build();
    }

    @PutMapping(path = "/api/contacts/{idContact}/addresses/{idAddress}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> update(User user,
                                            @RequestBody UpdateAddressRequest request,
                                            @PathVariable("idContact") String contactId,
                                            @PathVariable("idAddress") String addressId){
        request.setContactId(contactId);
        request.setAddressId(addressId);

        AddressResponse response = addressService.update(user, request);
        return WebResponse.<AddressResponse>builder().data(response).build();
    }

    @DeleteMapping(path = "/api/contacts/{idContact}/addresses/{idAddress}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> delete(User user, @PathVariable("idContact") String contactId, @PathVariable("idAddress")String addressId){
        addressService.delete(user, contactId, addressId);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(path = "/api/contacts/{idContact}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<AddressResponse>> listAddress(User user, @PathVariable("idContact") String contactId){
        List<AddressResponse> responses = addressService.listAddress(user, contactId);
        return WebResponse.<List<AddressResponse>>builder().data(responses).build();
    }

}
