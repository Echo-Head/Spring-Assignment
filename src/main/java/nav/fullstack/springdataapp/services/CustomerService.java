package nav.fullstack.springdataapp.services;

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

    public Optional<Customer> getCustomerById(int customerId){
        return customerRepository.findByCustomerId(customerId);
    }

    public List<Customer> getCustomerByName(String firstName, String lastName){
        List<Customer> value = customerRepository.findByFirstNameOrLastNameContainingIgnoreCase(firstName,lastName);
    return value;
    }

    public Set<Customer> getCustomersOffsetLimit(int o, int l){
         return customerRepository.getSetOfCustomersUsingOffsetAndLimit(o,l);
    }
//Other add customer method are in use
    //public Boolean addCustomer(int customerId, String firstName, String lastName, String country, String postalCode, String phone, String email){
       // customerRepository.insertCustomer(customerId, firstName, lastName, country, postalCode, phone, email);
      //  return true;
    //}

    public Customer addCustomer2(int customerId, String fName, String lastName, String country, String postalCode, String phone, String email) {
       // customerRepository.insertCustomer2();
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setFirstName(fName);
        customer.setLastName(lastName);
        customer.setCountry(country);
        customer.setPostalCode(postalCode);
        customer.setPhone(phone);
        customer.setEmail(email);
        customerRepository.save(customer);
        return customer;
    }


//public Boolean updateCustomerPhone(int customerId, String phone){
    //      Customer customer = customerRepository.findById(customerId).get();
    //    customer.setPhone(phone);
    //  customerRepository.save(customer);
    // return true;

    //}


//THIS METHOD WORKS
    public List<Object[]> getCountryWithMostCustomers(){
        return customerRepository.countryWithMostCustomers();

    }







}
