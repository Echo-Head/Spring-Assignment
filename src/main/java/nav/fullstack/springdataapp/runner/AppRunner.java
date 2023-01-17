package nav.fullstack.springdataapp.runner;

import nav.fullstack.springdataapp.repositories.CustomerRepository;
import nav.fullstack.springdataapp.services.CustomerService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    private final CustomerService customerService;

    public AppRunner(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //customerRepository.findById(1).get().getName();
        //System.out.println(customerService.getCustomerByName("Tim","Goyer"));
        //System.out.println(customerService.getCustomersOffsetLimit(2,4));
        //customerService.addCustomer(668,"Bob","Billy","Finland","5363","+46 543 65 432","something@something.com");
        customerService.changeCustomerPhoneNumber("44 444 444 44", 667);

    }

}
