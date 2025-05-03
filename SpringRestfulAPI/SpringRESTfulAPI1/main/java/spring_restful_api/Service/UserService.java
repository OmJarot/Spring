package spring_restful_api.Service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import spring_restful_api.Entity.User;
import spring_restful_api.Model.RegisterUserRequest;
import spring_restful_api.Model.UserResponse;
import spring_restful_api.Model.UserUpdateRequest;
import spring_restful_api.Repository.UserRepository;
import spring_restful_api.Security.BCrypt;

import java.util.Objects;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ValidationService validationService;


    @Transactional
    public void register(RegisterUserRequest request){
        validationService.validate(request);

        if (userRepository.existsById(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    public UserResponse get(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }

    @Transactional
    public UserResponse update(User user, UserUpdateRequest request){
        validationService.validate(request);

        if (Objects.nonNull(request.getName())){
            user.setName(request.getName());
        }
        if (Objects.nonNull(request.getPassword())){
            user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        }
        userRepository.save(user);

        return UserResponse.builder()
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }

}
