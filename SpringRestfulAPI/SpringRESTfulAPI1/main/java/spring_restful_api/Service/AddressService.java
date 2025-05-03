package spring_restful_api.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api.Entity.Address;
import spring_restful_api.Entity.Contact;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.AddressResponse;
import spring_restful_api.Model.CreateAddressRequest;
import spring_restful_api.Model.UpdateAddressRequest;
import spring_restful_api.Repository.AddressRepository;
import spring_restful_api.Repository.ContactRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    private ContactRepository contactRepository;

    private ValidationService validationService;

    private AddressResponse toAddressResponse(Address address){
        return AddressResponse.builder()
                .id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .province(address.getProvince())
                .country(address.getCountry())
                .postCode(address.getPostalCode())
                .build();
    }

    @Transactional
    public AddressResponse create(User user, CreateAddressRequest request){
        validationService.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setCountry(request.getCountry());
        address.setPostalCode(request.getPostCode());
        address.setContact(contact);

        addressRepository.save(address);

        return toAddressResponse(address);
    }

    @Transactional(readOnly = true)
    public AddressResponse get(User user, String contactId, String addressId){
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        Address address = addressRepository.findFirstByContactAndId(contact, addressId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        return toAddressResponse(address);
    }

    @Transactional
    public AddressResponse update(User user, UpdateAddressRequest request){
        validationService.validate(request);
        Contact contact = contactRepository.findFirstByUserAndId(user, request.getContactId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        Address address = addressRepository.findFirstByContactAndId(contact, request.getAddressId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setProvince(request.getProvince());
        address.setPostalCode(request.getPostCode());

        addressRepository.save(address);

        return toAddressResponse(address);
    }

    @Transactional
    public void delete(User user, String contactId, String addressId){
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        Address address = addressRepository.findFirstByContactAndId(contact, addressId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        addressRepository.delete(address);
    }

    @Transactional(readOnly = true)
    public List<AddressResponse> listAddress(User user, String contactId){
        Contact contact = contactRepository.findFirstByUserAndId(user, contactId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        List<Address> addresses = addressRepository.findAllByContact(contact);
        return addresses.stream().map(this::toAddressResponse).toList();
    }

}
