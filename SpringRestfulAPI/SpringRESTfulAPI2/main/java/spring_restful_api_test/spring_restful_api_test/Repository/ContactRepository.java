package spring_restful_api_test.spring_restful_api_test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring_restful_api_test.spring_restful_api_test.Entity.Contact;
import spring_restful_api_test.spring_restful_api_test.Entity.User;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> , JpaSpecificationExecutor<Contact> {

    Optional<Contact> findFirstByUserAndId(User user, String id);

    String id(String id);
}
