public class Address {

    private String streetName;
    private String zipcode;
    private String city;

    public Address(){
    }

    public Address(String streetName, String zipcode, String city) {
        this.streetName = streetName;
        this.zipcode = zipcode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString(){
        return this.streetName + " " + this.zipcode + " " + this.city ;
    }
}
