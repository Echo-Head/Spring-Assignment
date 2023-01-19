package nav.fullstack.springdataapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity()
//@Getter @Setter
public class Customer {

    @Id
    @Column(nullable = false)
    private int customerId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(length = 40, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(length = 40)
    private String country;

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(length = 10)
    private String postalCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(length = 24)
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(length = 60, nullable = false)
    private String email;

    public Customer() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + customerId + " " + postalCode + " " + country + " " + phone + " " + email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

