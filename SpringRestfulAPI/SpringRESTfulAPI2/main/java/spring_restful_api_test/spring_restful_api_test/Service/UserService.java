package spring_restful_api_test.spring_restful_api_test.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api_test.spring_restful_api_test.Entity.User;
import spring_restful_api_test.spring_restful_api_test.Model.RegisterUserRequest;
import spring_restful_api_test.spring_restful_api_test.Model.UserResponse;
import spring_restful_api_test.spring_restful_api_test.Model.UserUpdateRequest;
import spring_restful_api_test.spring_restful_api_test.Repository.UserRepository;
import spring_restful_api_test.spring_restful_api_test.Security.BCrypt;

import java.util.Objects;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private ValidateService validator;

    @Transactional
    public void register(RegisterUserRequest request){
        validator.validate(request);

        if (userRepository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public UserResponse getCurrent(User user){
        return UserResponse.builder()
                .name(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Transactional
    public UserResponse update(User user, UserUpdateRequest request){
        validator.validate(request);

        if (Objects.nonNull(request.getName())){
            user.setName(request.getName());
        }
        if (Objects.nonNull(request.getPassword())){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }
        userRepository.save(user);

        return UserResponse.builder()
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }

}
