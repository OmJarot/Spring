package spring_restful_api.Controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.*;
import spring_restful_api.Service.ContactService;

import java.util.List;

@RestController
@AllArgsConstructor
public class ContactController {

    private ContactService contactService;

    @PostMapping(
            path = "/api/contacts",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> create(User user, @RequestBody CreateContactRequest request){
        ContactResponse response = contactService.create(user, request);
        return WebResponse.<ContactResponse>builder().data(response).build();
    }

    @GetMapping(
            path = "/api/contacts/{idContact}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> get(User user, @PathVariable("idContact") String id){
        ContactResponse contact = contactService.getContact(user, id);
        return WebResponse.<ContactResponse>builder().data(contact).build();
    }

    @PutMapping(
            path = "/api/contacts/{idContact}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> update(User user,
                                               @RequestBody UpdateContactRequest request,
                                               @PathVariable("idContact") String id){
        request.setId(id);

        ContactResponse response = contactService.updateContact(user, request);
        return WebResponse.<ContactResponse>builder().data(response).build();
    }

    @DeleteMapping(path = "/api/contacts/{idContact}")
    public WebResponse<String> delete(User user, @PathVariable("idContact") String id){
        contactService.delete(user, id);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(path = "/api/contacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<ContactResponse>> search(User user,
                                                     @RequestParam(value = "name", required = false) String name,
                                                     @RequestParam(value = "email", required = false)String email,
                                                     @RequestParam(value = "phone", required = false)String phone,
                                                     @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
        SearchContactRequest request = SearchContactRequest.builder()
                .page(page)
                .size(size)
                .name(name)
                .email(email)
                .phone(phone)
                .build();

        Page<ContactResponse> search = contactService.search(user, request);
        return WebResponse.<List<ContactResponse>>builder()
                .data(search.getContent())
                .paging(PagingResponse.builder()
                        .currentPage(search.getNumber())
                        .totalPage(search.getTotalPages())
                        .size(search.getSize())
                        .build())
                .build();
    }
}
