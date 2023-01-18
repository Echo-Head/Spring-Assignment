package nav.fullstack.springdataapp.services;

import nav.fullstack.springdataapp.models.Customer;
import nav.fullstack.springdataapp.models.CustomerSpender;
import nav.fullstack.springdataapp.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {this.invoiceRepository = invoiceRepository;}

    public Object[] getHighestSpenderCustomer(){
        List<Object[]> value = invoiceRepository.findHighestSpenderCustomer();
        List l2=value;
        Object[] o1=(Object[])l2.get(0);
        return o1;
    }



}
