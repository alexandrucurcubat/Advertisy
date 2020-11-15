package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
