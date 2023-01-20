package nav.fullstack.springdataapp.models;


public class CustomerCountry {

    private String country;

    private int customerId;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return country + "" + customerId;
    }
}
