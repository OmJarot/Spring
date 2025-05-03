package spring_restful_api_test.spring_restful_api_test.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.LoginRequest;
import spring_restful_api_test.spring_restful_api_test.Model.TokenResponse;
import spring_restful_api_test.spring_restful_api_test.Repository.UserRepository;
import spring_restful_api_test.spring_restful_api_test.Security.BCrypt;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    private ValidateService validator;

    @Transactional
    public TokenResponse login(LoginRequest request){
        validator.validate(request);

        User user = userRepository.findById(request.getUsername()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())){
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());

            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        }else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }

    private Long next30Days(){
        return System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30);
    }

    @Transactional
    public void logout(User user){
        user.setToken(null);
        user.setTokenExpiredAt(null);
        userRepository.save(user);
    }

}
