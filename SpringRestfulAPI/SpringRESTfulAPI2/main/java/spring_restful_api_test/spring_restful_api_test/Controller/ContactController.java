package spring_restful_api_test.spring_restful_api_test.Controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.*;
import spring_restful_api_test.spring_restful_api_test.Service.ContactService;

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
    public WebResponse<ContactResponse> createContact(User user, @RequestBody ContactRequest request){
        ContactResponse contact = contactService.createContact(user, request);
        return WebResponse.<ContactResponse>builder().data(contact).build();
    }

    @GetMapping(path = "/api/contacts/{idContact}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<ContactResponse> getCurrent(User user, @PathVariable("idContact") String id){
        ContactResponse current = contactService.getCurrent(user, id);
        return WebResponse.<ContactResponse>builder().data(current).build();
    }

    @PutMapping(
            path = "/api/contacts/{idContact}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ContactResponse> update(User user,
                                               @RequestBody UpdateContactRequest request,
                                               @PathVariable("idContact") String id
    ){
        request.setIdContact(id);
        ContactResponse update = contactService.updateContact(user, request);
        return WebResponse.<ContactResponse>builder().data(update).build();
    }

    @DeleteMapping(
            path = "/api/contacts/{idContact}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(User user, @PathVariable("idContact") String id){
        contactService.removeContact(user, id);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(path = "/api/contacts",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<ContactResponse>> search(
            User user,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email",required = false) String email,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ){
        SearchContactRequest request = SearchContactRequest.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .page(page)
                .size(size)
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
