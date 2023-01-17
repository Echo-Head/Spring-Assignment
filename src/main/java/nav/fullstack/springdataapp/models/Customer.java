package nav.fullstack.springdataapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity()
@Getter @Setter @ToString
public class Customer {

    @Id
    @Column(nullable = false)
    private int customerId;

    @Column(length = 40, nullable = false )
    private String first_name;

    @Column(length = 20, nullable = false )
    private String last_name;

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
    private String postal_code;

    @Column(length = 24)
    private String phone;

//    @Column(length = 24)
//    private String fax;

    @Column(length = 60, nullable = false )
    private String email;
    private final int support_rep_id = customerId;


    public Customer(){}

    public void getName() {
    }
}
