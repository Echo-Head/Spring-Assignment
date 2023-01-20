package nav.fullstack.springdataapp.repositories;

import nav.fullstack.springdataapp.models.Customer;
import nav.fullstack.springdataapp.services.interfaces.ICustomerGenre;
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

    // Find any given customer's favorite genre
    @Query(value = "SELECT g.name as genreName,count(g.name) as GenreChosenMost from customer as c\n" +
            "inner join invoice as i\n" +
            "on i.customer_id = c.customer_id\n" +
            "inner join invoice_line as il\n" +
            "on il.invoice_id = i.invoice_id\n" +
            "inner join track as t\n" +
            "on t.track_id = il.track_id\n" +
            "inner join genre as g\n" +
            "on g.genre_id = t.genre_id\n" +
            "where c.customer_id =?\n" +
            "group by genreName\n" +
            "Order by GenreChosenMost desc\n" +
            "LIMIT 1", nativeQuery = true)
    ICustomerGenre getCustomerFavoriteGenre(int customerId);
}
