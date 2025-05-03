package spring_restful_api_test.spring_restful_api_test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_restful_api_test.spring_restful_api_test.Entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findFirstByToken(String token);

}
