package nav.fullstack.springdataapp.repositories;

import jakarta.transaction.Transactional;
import nav.fullstack.springdataapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    Optional<Customer> findByCustomerId(int customerId);

    Optional<Customer> findAllByFirstNameAndLastName(String firstName, String lastName);

    Set<Customer> findAllByFirstName(String firstName);
}
