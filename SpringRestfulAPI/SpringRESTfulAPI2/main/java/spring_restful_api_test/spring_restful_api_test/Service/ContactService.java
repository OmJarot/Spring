package spring_restful_api_test.spring_restful_api_test.Service;

import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api_test.spring_restful_api_test.Entity.Contact;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.ContactResponse;
import spring_restful_api_test.spring_restful_api_test.Model.ContactRequest;
import spring_restful_api_test.spring_restful_api_test.Model.SearchContactRequest;
import spring_restful_api_test.spring_restful_api_test.Model.UpdateContactRequest;
import spring_restful_api_test.spring_restful_api_test.Repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Service
public class ContactService {

    private ContactRepository contactRepository;

    private ValidateService validator;

    private ContactResponse toContactResponse(Contact contact){
        return ContactResponse.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .build();
    }

    @Transactional
    public ContactResponse createContact(User user, ContactRequest request){
        validator.validate(request);

        Contact contact = new Contact();
        contact.setId(UUID.randomUUID().toString());
        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contact.setUser(user);
        contactRepository.save(contact);

        return toContactResponse(contact);
    }


    @Transactional(readOnly = true)
    public ContactResponse getCurrent(User user, String id){
        Contact contact = contactRepository.findFirstByUserAndId(user, id).orElseThrow
                (() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));
        return toContactResponse(contact);
    }

    @Transactional
    public ContactResponse updateContact(User user, UpdateContactRequest request){
        validator.validate(request);

        Contact contact = contactRepository.findFirstByUserAndId(user, request.getIdContact())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contactRepository.save(contact);

        return toContactResponse(contact);
    }

    @Transactional
    public void removeContact(User user, String idContact){
        Contact contact = contactRepository.findFirstByUserAndId(user, idContact)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found"));

        contactRepository.delete(contact);
    }

    @Transactional
    public Page<ContactResponse> search(User user, SearchContactRequest request){
        Specification<Contact> specification = (root, query, builder) ->{
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("user"), user));

            if (Objects.nonNull(request.getName())){
                predicates.add((builder.or(
                        builder.like(root.get("firstName"), request.getName()),
                        builder.like(root.get("lastName"), request.getName())
                )));
            }

            if (Objects.nonNull(request.getEmail())){
                predicates.add(builder.like(root.get("email"), "%"+request.getEmail()+"%"));
            }
            if (Objects.nonNull(request.getPhone())){
                predicates.add(builder.like(root.get("phone"), request.getPhone()));
            }
            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Contact> contacts = contactRepository.findAll(specification, pageable);
        List<ContactResponse> responses = contacts.stream().map(this::toContactResponse).toList();

        return new PageImpl<>(responses, pageable, contacts.getTotalElements());
    }
}
