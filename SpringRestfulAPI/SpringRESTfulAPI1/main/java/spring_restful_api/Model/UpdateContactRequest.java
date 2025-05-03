package spring_restful_api.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
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
public class UpdateContactRequest {

    @JsonIgnore
    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 100)
    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String phone;

}
