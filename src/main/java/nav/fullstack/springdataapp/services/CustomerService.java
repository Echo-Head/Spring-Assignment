package nav.fullstack.springdataapp.services;

import nav.fullstack.springdataapp.models.Customer;
import nav.fullstack.springdataapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
