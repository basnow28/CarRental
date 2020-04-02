public class Customer {

    private String customerId;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String email;
    private String driverLicence;
    private String driverSince;
    private Address address;

    public Customer(){
    }

    public Customer(String customerId, String firstName, String lastName, String mobilePhone, String email, String driverLicence, String driverSince, Address address) {
        this.customerId=customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.driverLicence = driverLicence;
        this.driverSince = driverSince;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDriverLicence() {
        return driverLicence;
    }

    public void setDriverLicence(String driverLicence) {
        this.driverLicence = driverLicence;
    }

    public String getDriverSince() {
        return driverSince;
    }

    public void setDriverSince(String driverSince) {
        this.driverSince = driverSince;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + " " + this.mobilePhone + " " + this.email +
                " " + " " + this.driverLicence + " "  + this.driverSince + " " + this.address;
    }

}
