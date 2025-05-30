package spring_restful_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    private String phone;

    private String email;

    @OneToMany(mappedBy = "contact")
    private List<Address> addresses;
}
