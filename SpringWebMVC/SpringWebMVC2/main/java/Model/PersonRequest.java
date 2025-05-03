package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    private String firstName;

    private String lastName;

    private String email;

    private Address address;

    private List<String> hobbies;

    private List<SocialMedia> socialMedia;
}
