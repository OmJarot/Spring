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
public class AddressResponse {

    private String id;

    private String street;

    private String city;

    private String province;

    private String country;

    private String postalCode;

}
