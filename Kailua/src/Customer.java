public class Customer {

    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String email;
    private String driverLicence;
    private String driverSince;
    private int address_id;

    public Customer(){
    }

    public Customer(String firstName, String lastName, String mobilePhone, String email, String driverLicence, String driverSince, int address_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.driverLicence = driverLicence;
        this.driverSince = driverSince;
        this.address_id = address_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.lastName + " " + this.mobilePhone + " " + this.email +
                " " + " " + this.driverLicence + " "  + this.driverSince + " " + this.address_id;
    }

}
