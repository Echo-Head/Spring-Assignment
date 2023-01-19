package nav.fullstack.springdataapp.repositories;

import nav.fullstack.springdataapp.models.Customer;
import nav.fullstack.springdataapp.models.CustomerSpender;
import nav.fullstack.springdataapp.services.interfaces.ICustomerSpender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface InvoiceRepository extends JpaRepository<CustomerSpender, Integer> {

@Query (value = "SELECT customer_id as customerId, SUM(total) as totalInvoice\n" +
                    "FROM invoice\n" +
                    "GROUP BY customer_id\n" +
                    "ORDER BY totalInvoice DESC\n" +
                    "LIMIT 1", nativeQuery = true)
ICustomerSpender findHighestSpenderCustomer();



}
