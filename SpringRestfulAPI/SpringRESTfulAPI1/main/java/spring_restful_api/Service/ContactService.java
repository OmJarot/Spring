package spring_restful_api.Service;

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
import spring_restful_api.Entity.Contact;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.ContactResponse;
import spring_restful_api.Model.CreateContactRequest;
import spring_restful_api.Model.SearchContactRequest;
import spring_restful_api.Model.UpdateContactRequest;
import spring_restful_api.Repository.ContactRepository;
import spring_restful_api.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ContactService {

    private final UserRepository userRepository;
    private ContactRepository contactRepository;

    private ValidationService validationService;

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
    public ContactResponse create(User user, CreateContactRequest request){
        validationService.validate(request);

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
    public ContactResponse getContact(User user, String id){
        Contact contact = contactRepository.findFirstByUserAndId(user, id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        return toContactResponse(contact);
    }

    @Transactional
    public ContactResponse updateContact(User user, UpdateContactRequest request){
        Contact contact = contactRepository.findFirstByUserAndId(user, request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not Found"));

        contact.setFirstName(request.getFirstName());
        contact.setLastName(request.getLastName());
        contact.setEmail(request.getEmail());
        contact.setPhone(request.getPhone());
        contactRepository.save(contact);

        return toContactResponse(contact);
    }

    @Transactional
    public void delete(User user, String id){
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Not found"));

        contactRepository.delete(contact);
    }

    @Transactional
    public Page<ContactResponse> search(User user, SearchContactRequest request){
        Specification<Contact> specification = (root, query, builder) ->{
            List<Predicate> predicates = new ArrayList<>();
            predicates.add(builder.equal(root.get("user"),user));

            if (Objects.nonNull(request.getName())){
                predicates.add(builder.or(
                        builder.like(root.get("firstName"), "%"+ request.getName()+"%"),
                        builder.like(root.get("lastName"), "%"+ request.getName()+"%")
                ));
            }

            if (Objects.nonNull(request.getEmail())){
                predicates.add(builder.like(root.get("email"), "%"+request.getEmail()+"%"));
            }
            if (Objects.nonNull(request.getPhone())){
                predicates.add(builder.like(root.get("phone"), "%"+request.getPhone()+"%"));
            }
            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
        };
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Contact> contacts = contactRepository.findAll(specification, pageable);
        List<ContactResponse> contactResponses = contacts.getContent().stream()
                .map(this::toContactResponse)
                .toList();
        return new PageImpl<>(contactResponses, pageable, contacts.getTotalElements());
    }
}
