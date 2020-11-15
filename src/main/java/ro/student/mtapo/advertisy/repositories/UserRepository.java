package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
