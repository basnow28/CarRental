public class Car {

    private String brand;
    private String model;
    private String plate;
    private String regDate;
    private String odometer;
    private String fuelType;
    private int carType;

    public Car(){

    };

    //public Car(String brand, String model, String plate, String regDate, String odometer, String fuelType){
    //}

    public Car(String brand, String model, String plate, String regDate, String odometer, String fuelType, int carType) {
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.regDate = regDate;
        this.odometer = odometer;
        this.fuelType = fuelType;
        this.carType = carType;

    }

    /*public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }*/

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getCarType() { return carType; };

    public void setCarType(int carType) { this.carType = carType; }

    @Override
    public String toString() {
        return /*carId* + " " + */ brand + " " + model + " " + plate +  " " + regDate + " " + odometer +
                " " + fuelType + " " + carType;
    }

    public String toStringConsole() {
        return /*"Car ID: " + carId + ".*/ "Brand: " + brand + ". Model: " + model + ". Licence Plate: " + plate + ", registered on: " + regDate +
                ". Odometer: " + odometer + ". Fuel Type is " + fuelType + ". Car type is " + carType;
    }
}
