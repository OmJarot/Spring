package spring_restful_api.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.RegisterUserRequest;
import spring_restful_api.Model.UserResponse;
import spring_restful_api.Model.UserUpdateRequest;
import spring_restful_api.Model.WebResponse;
import spring_restful_api.Service.UserService;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request){
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> getUser(User user){
        UserResponse response = userService.get(user);
        return WebResponse.<UserResponse>builder().data(response).build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> updateUser(User user, @RequestBody UserUpdateRequest request){
        UserResponse update = userService.update(user, request);
        return WebResponse.<UserResponse>builder().data(update).build();
    }

}
