package nav.fullstack.springdataapp.repositories;

import nav.fullstack.springdataapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // Find a customer by their ID
    Optional<Customer> findByCustomerId(int customerId);

    // Find a customer by their name
    List<Customer> findByFirstNameOrLastNameContainingIgnoreCase(String firstName, String lastName);

    // Find a subset of customers using the OFFSET and LIMIT parameters
    @Query(value = "SELECT * FROM customer OFFSET ? LIMIT ?", nativeQuery = true)
    Set<Customer> getSetOfCustomersUsingOffsetAndLimit(int o, int l);

    // Find the country with the highest amount of customers associated with it
    @Query("SELECT c.country, COUNT(c.country) as customerCount FROM Customer c GROUP BY c.country ORDER BY customerCount DESC LIMIT 1")
    List<Object[]> countryWithMostCustomers();
}
