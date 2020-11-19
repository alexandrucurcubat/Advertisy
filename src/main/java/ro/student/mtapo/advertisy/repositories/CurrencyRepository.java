package ro.student.mtapo.advertisy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.student.mtapo.advertisy.models.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
