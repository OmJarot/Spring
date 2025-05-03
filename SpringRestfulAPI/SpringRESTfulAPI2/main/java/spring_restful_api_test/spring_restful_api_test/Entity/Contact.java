package spring_restful_api_test.spring_restful_api_test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(
            name = "username",
            referencedColumnName = "username"
    )
    private User user;


    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String email;

    private String phone;

    @OneToMany(mappedBy = "contactId")
    private List<Address> address;

}
