package spring_restful_api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_restful_api.Entity.Address;
import spring_restful_api.Entity.Contact;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    Optional<Address> findFirstByContactAndId(Contact contact, String id);

    List<Address> findAllByContact(Contact contact);

}
