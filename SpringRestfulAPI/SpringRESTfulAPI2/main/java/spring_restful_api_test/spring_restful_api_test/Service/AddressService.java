package spring_restful_api_test.spring_restful_api_test.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api_test.spring_restful_api_test.Entity.Address;
import spring_restful_api_test.spring_restful_api_test.Entity.Contact;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.AddressRequest;
import spring_restful_api_test.spring_restful_api_test.Model.AddressResponse;
import spring_restful_api_test.spring_restful_api_test.Model.UpdateAddressRequest;
import spring_restful_api_test.spring_restful_api_test.Repository.AddressRepository;
import spring_restful_api_test.spring_restful_api_test.Repository.ContactRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    private ContactRepository contactRepository;

    private ValidateService validator;

    private AddressResponse toAddressResponse(Address address){
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .postalCode(address.getPostalCode())
                .build();
    }

    @Transactional
    public AddressResponse create(User user, AddressRequest request){
        validator.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getIdContact())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        address.setContactId(contact);

        addressRepository.save(address);

        return toAddressResponse(address);
    }

    @Transactional(readOnly = true)
    public AddressResponse getAddress(User user, String idContact, String idAddress){
        Contact contact = contactRepository.findFirstByUserAndId(user, idContact)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        Address address = addressRepository.findFirstByContactIdAndId(contact, idAddress)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        return toAddressResponse(address);
    }

    @Transactional
    public AddressResponse update(User user, UpdateAddressRequest request){
        validator.validate(request);
        Contact contact = contactRepository.findFirstByUserAndId(user, request.getIdContact())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        Address address = addressRepository.findFirstByContactIdAndId(contact, request.getIdAddress())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostalCode());
        addressRepository.save(address);

        return toAddressResponse(address);
    }

    @Transactional
    public void remove(User user, String idContact, String idAddress){
        Contact contact = contactRepository.findFirstByUserAndId(user, idContact)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        Address address = addressRepository.findFirstByContactIdAndId(contact, idAddress)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        addressRepository.delete(address);
    }

    @Transactional(readOnly = true)
    public List<AddressResponse> getAll(User user, String contactId){
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        List<Address> addresses = addressRepository.findAllByContactId(contact);

        return addresses.stream().map(this::toAddressResponse).toList();
    }

}
