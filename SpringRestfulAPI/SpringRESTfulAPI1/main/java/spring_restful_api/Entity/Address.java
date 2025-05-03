package spring_restful_api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "addresses")
public class Address {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(
            name = "contact_id",
            referencedColumnName = "id"
    )
    private Contact contact;

    private String street;

    private String city;

    private String province;

    private String country;

    @Column(name = "postal_code")
    private String postalCode;

}
