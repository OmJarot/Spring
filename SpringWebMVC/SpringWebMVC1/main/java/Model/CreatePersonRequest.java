package Model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePersonRequest {

    private List<String> hobbies;//untuk mengaksesnya hobbies[0]

    private List<CreateSocialMediaRequest> socialMedia;//untuk mengaksesnya socialMedia[0].name

    private CreateAddressRequest address;//ini adalah nested, untuk mengaksesnya cth: address.city

    @NotBlank
    private String firstName;

    private String middleName;

    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String phone;

}
