public class Contract {

    private String carId;
    private String customerId;
    private String fromDate;
    private String fromTime;
    private String toDate;
    private String toTime;
    private String maxKm;
    private String odometer;

    public Contract(){
    }

    public Contract(String carId, String customerId, String fromDate, String fromTime, String toDate, String toTime, String maxKm, String odometer) {
        this.carId = carId;
        this.customerId = customerId;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
        this.maxKm = maxKm;
        this.odometer = odometer;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(String maxKm) {
        this.maxKm = maxKm;
    }

    public String getOdometer() {
        return odometer;
    }

    public void setOdometer(String odometer) {
        this.odometer = odometer;
    }

    @Override
    public String toString() {
        return carId + " " + customerId + " " + fromDate + " " + fromTime + " " + toDate +
                " " + toTime + " " + maxKm + " " + odometer;
    }

    public String toStringConsole() {
        return "Car ID: " + carId + ". Customer ID: " + customerId + ". Rented from " + fromDate + " at " + fromTime + " to " + toDate +
                " at " + toTime + ". To be driven max " + maxKm + "km. Current mileage " + odometer + "km.";
    }
}
