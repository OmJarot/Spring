package spring_restful_api_test.spring_restful_api_test.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterUserRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String username;

    @NotBlank
    @Size(max = 100)
    private String password;

}
