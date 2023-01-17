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

    public Optional<Customer> getCustomerById(int id){
        return customerRepository.findByCustomerId(id);
    }

    public Customer getCustomerByName(String firstName, String lastName){
        Optional<Customer> value = customerRepository.findByFirstNameAndLastName(firstName,lastName);
    return value.get();
    }

    public Set<Customer> getCustomersOffsetLimit(int o, int l){
         return customerRepository.getSetOfCustomersUsingOffsetAndLimit(o,l);
    }

    public Boolean addCustomer(int customerId, String firstName, String lastName, String country, String postalCode, String phone, String email){
        customerRepository.insertCustomer(customerId, firstName, lastName, country, postalCode, phone, email);
        return true;
    }

    public Boolean changeCustomerPhoneNumber(String phone, int customerId){
        customerRepository.updateCustomerPhoneNumber(phone,customerId);
        return true;

    }

//public Boolean updateCustomerPhone(int customerId, String phone){
  //      Customer customer = customerRepository.findById(customerId).get();
    //    customer.setPhone(phone);
      //  customerRepository.save(customer);
       // return true;

//}

// for each country
    //
Boolean countryWithMostCustomers(){
  customerRepository.countryWithMostCustomers()

};


}
