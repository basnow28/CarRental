public class CarType {

    private String engine;
    private String gearType;
    private boolean cruiseControl;
    private int numberOfSeats;
    private String seatsType;
    private boolean aircon;
    private int hp;
    private String typeName;

    public CarType(){
    }

    public CarType(String engine, String gearType, boolean cruiseControl, int numberOfSeats, String seatsType, boolean aircon, int hp, String typeName) {
        this.engine = engine;
        this.gearType = gearType;
        this.cruiseControl = cruiseControl;
        this.numberOfSeats = numberOfSeats;
        this.seatsType = seatsType;
        this.aircon = aircon;
        this.hp = hp;
        this.typeName = typeName;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearType() {
        return gearType;
    }

    public void setGearType(String gearType) {
        this.gearType = gearType;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getSeatsType() {
        return seatsType;
    }

    public void setSeatsType(String seatsType) {
        this.seatsType = seatsType;
    }

    public boolean isAircon() {
        return aircon;
    }

    public void setAircon(boolean aircon) {
        this.aircon = aircon;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return engine + " " + gearType + " " + cruiseControl + " " + numberOfSeats + " " + seatsType +  " " + aircon + " " + hp +
                " " + typeName;
    }
}
