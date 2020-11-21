package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByEmail(String email);

    User findByEmail(String email);

    List<User> findAllByUsernameContaining(String queryString);
}
