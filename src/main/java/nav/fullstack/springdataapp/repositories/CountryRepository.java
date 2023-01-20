package nav.fullstack.springdataapp.repositories;

import nav.fullstack.springdataapp.models.CustomerCountry;
import nav.fullstack.springdataapp.services.interfaces.IHighestCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CountryRepository extends JpaRepository<CustomerCountry, Integer> {

    @Query(value = "SELECT c.country, COUNT(c.country) as customerCount FROM customer c GROUP BY c.country ORDER BY customerCount DESC LIMIT 1", nativeQuery = true)
    IHighestCountry countryWithMostCustomers();
}
