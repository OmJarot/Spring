package spring_restful_api_test.spring_restful_api_test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring_restful_api_test.spring_restful_api_test.Entity.Address;
import spring_restful_api_test.spring_restful_api_test.Entity.Contact;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> , JpaSpecificationExecutor<Address> {

    Optional<Address> findFirstByContactIdAndId(Contact contactId, String id);

    List<Address> findAllByContactId(Contact contactId);

}
