package nav.fullstack.springdataapp.repositories;

import nav.fullstack.springdataapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Integer> {

    Optional<Customer> findByCustomerId(int customerId);
    //@Query("SELECT first_name, last_name FROM customer")
    Optional<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "SELECT * FROM customer OFFSET ? LIMIT ?", nativeQuery = true)
    Set<Customer> getSetOfCustomersUsingOffsetAndLimit(int o, int l);


    @Query(value = "INSERT INTO customer (customer_id, first_name, last_name, country, postal_code, phone, email ) VALUES (?,?,?,?,?,?,?)",nativeQuery = true)
    void insertCustomer(int customerId, String firstName, String lastName, String country, String postalCode, String phone, String email);

    @Modifying
    @Query(value = "UPDATE customer SET phone = ?1 WHERE customer_id = ?2",nativeQuery = true)
    void updateCustomerPhoneNumber(String phone, int customerId);

}
