package spring_restful_api_test.spring_restful_api_test.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.RegisterUserRequest;
import spring_restful_api_test.spring_restful_api_test.Model.UserResponse;
import spring_restful_api_test.spring_restful_api_test.Model.UserUpdateRequest;
import spring_restful_api_test.spring_restful_api_test.Model.WebResponse;
import spring_restful_api_test.spring_restful_api_test.Service.UserService;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private WebResponse<String> register(@RequestBody RegisterUserRequest request){
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE)
    private WebResponse<UserResponse> getCurrent(User user){
        UserResponse current = userService.getCurrent(user);
        return WebResponse.<UserResponse>builder().data(current).build();
    }

    @PatchMapping(path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private WebResponse<UserResponse> update(User user, @RequestBody UserUpdateRequest request){
        UserResponse update = userService.update(user, request);
        return WebResponse.<UserResponse>builder().data(update).build();
    }

}
