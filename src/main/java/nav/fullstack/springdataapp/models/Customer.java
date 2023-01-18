package nav.fullstack.springdataapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity()
@Getter @Setter
public class Customer {

    @Id
    @Column(nullable = false)
    private int customerId;

    @Column(length = 40, nullable = false )
    private String firstName;

    @Column(length = 20, nullable = false )
    private String lastName;

//    @Column(length = 88)
//private String company;

//    @Column(length = 70)
//    private String address;

//    @Column(length = 40)
//    private String city;

//    @Column(length = 40)
//    private String state;

    @Column(length = 40)
    private String country;

    @Column(length = 10)
    private String postalCode;

    @Column(length = 24)
    private String phone;

//    @Column(length = 24)
//    private String fax;

    @Column(length = 60, nullable = false )
    private String email;
    private final int supportRepId = customerId;


    public Customer(){}

    @Override
    public String toString(){
        return firstName + lastName + customerId;
    };

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


}

