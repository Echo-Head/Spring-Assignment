package nav.fullstack.springdataapp.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity()
@Table(name = "invoice")
public class CustomerSpender {

@Id
@Column (nullable = false)
private int invoiceId;

@Column(nullable = false)
private int customerId;

@Column(nullable = false)
public double total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }
}
