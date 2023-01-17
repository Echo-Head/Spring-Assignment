package nav.fullstack.springdataapp.service;

import nav.fullstack.springdataapp.models.Customer;
import nav.fullstack.springdataapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> readAllTheCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id){
        return customerRepository.findByCustomerId(id);
    }

    public Set<Customer> findAllByFirstName(String firstName){
        return customerRepository.findAllByFirstName(firstName);
    }

    public Optional<Customer> findAllByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public Boolean updateCustomerPhone() {
        Customer customer = customerRepository.findById(2).get();
        customerRepository.save(customer);
        return true;
    }
}
