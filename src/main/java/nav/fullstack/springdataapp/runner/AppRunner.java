package nav.fullstack.springdataapp.runner;

import nav.fullstack.springdataapp.services.CustomerService;
import nav.fullstack.springdataapp.services.InvoiceService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {
    private final CustomerService customerService;
    private final InvoiceService invoiceService;

    public AppRunner(CustomerService customerService, InvoiceService invoiceService) {
        this.customerService = customerService;
        this.invoiceService = invoiceService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(customerService.readAllTheCustomers());
        System.out.println(customerService.getCustomerById(13));
        System.out.println(customerService.getCustomerByName("Tim", "Go"));
        System.out.println(customerService.getCustomersOffsetLimit(2,4));
       customerService.addCustomer2(700,"Bob","Billy","Finland","5363","+46 543 65 432","something@something.com");
        //customerService.changeCustomerPhoneNumber("44 444 444 44", 667);
        //System.out.println(invoiceService.getHighestSpenderCustomer());
        System.out.println(customerService.getCountryWithMostCustomers());

    }

}
