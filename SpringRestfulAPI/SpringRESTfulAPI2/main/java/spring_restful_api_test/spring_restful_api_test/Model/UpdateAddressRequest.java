package spring_restful_api_test.spring_restful_api_test.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UpdateAddressRequest {

    @NotBlank
    @JsonIgnore
    private String idContact;

    @NotBlank
    @JsonIgnore
    private String idAddress;

    @Size(max = 100)
    private String street;

    @Size(max = 100)
    private String city;

    @Size(max = 100)
    private String province;

    @NotBlank
    @Size(max = 100)
    private String country;

    @Size(max = 100)
    private String postalCode;

}
