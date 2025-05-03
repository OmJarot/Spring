package spring_restful_api.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.LoginUserRequest;
import spring_restful_api.Model.TokenResponse;
import spring_restful_api.Repository.UserRepository;
import spring_restful_api.Security.BCrypt;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepository userRepository;

    private ValidationService validationService;

    @Transactional
    public TokenResponse login(LoginUserRequest request){
        validationService.validate(request);

        User user = userRepository.findById(request.getUsername()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong")
        );

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

    public Long next30Days(){
        return System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30);
    }

    @Transactional
    public void logout(User user){
        user.setToken(null);
        user.setTokenExpiredAt(null);
        userRepository.save(user);
    }
}
