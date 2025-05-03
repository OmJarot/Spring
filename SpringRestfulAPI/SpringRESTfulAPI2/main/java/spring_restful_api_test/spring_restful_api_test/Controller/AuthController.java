package spring_restful_api_test.spring_restful_api_test.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.LoginRequest;
import spring_restful_api_test.spring_restful_api_test.Model.TokenResponse;
import spring_restful_api_test.spring_restful_api_test.Model.WebResponse;
import spring_restful_api_test.spring_restful_api_test.Service.AuthService;

@RestController
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping(path = "/api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<TokenResponse> login(@RequestBody LoginRequest request) {
        TokenResponse login = authService.login(request);
        return WebResponse.<TokenResponse>builder()
                .data(login)
                .build();
    }

    @DeleteMapping(path = "/api/auth/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> logout(User user){
        authService.logout(user);
        return WebResponse.<String>builder().data("OK").build();
    }

}
