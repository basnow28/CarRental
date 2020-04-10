public class Contract {

    private String carId;
    private String customerId;
    private String fromDate;
    private String fromTime;
    private String toDate;
    private String toTime;
    private int maxKm;
    private int km;

    public Contract(){
    }

    public Contract(String carId, String customerId, String fromDate, String fromTime, String toDate, String toTime, int maxKm, int km) {
        this.carId = carId;
        this.customerId = customerId;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
        this.maxKm = maxKm;
        this.km = km;
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

    public int getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public String toString() {
        return carId + " " + customerId + " " + fromDate + " " + fromTime + " " + toDate +
                " " + toTime + " " + maxKm + " " + km;
    }

    public String toStringConsole() {
        return "Car ID: " + carId + ". Customer ID: " + customerId + ". Rented from " + fromDate + " at " + fromTime + " to " + toDate +
                " at " + toTime + ". To be driven max " + maxKm + "km. Current mileage " + km + "km.";
    }
}
