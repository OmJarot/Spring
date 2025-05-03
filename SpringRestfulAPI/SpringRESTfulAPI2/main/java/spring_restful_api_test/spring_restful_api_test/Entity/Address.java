package spring_restful_api_test.spring_restful_api_test.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    private String id;

    @ManyToOne
    @JoinColumn(
            name = "contact_id",
            referencedColumnName = "id"
    )
    private Contact contactId;

    private String street;

    private String city;

    private String province;

    private String country;

    @Column(name = "postal_code")
    private String postalCode;
}
