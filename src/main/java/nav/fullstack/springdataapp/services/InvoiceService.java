package nav.fullstack.springdataapp.services;

import nav.fullstack.springdataapp.models.Customer;
import nav.fullstack.springdataapp.models.CustomerSpender;
import nav.fullstack.springdataapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {this.invoiceRepository = invoiceRepository;}

    public Optional<CustomerSpender> getHighestSpenderCustomer(){
        Optional<CustomerSpender> value = invoiceRepository.findHighestSpenderCustomer();
        return value;
    }


}
