import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Service {

    public static Scanner scanner = new Scanner(System.in);

    public Service(){
    }

    public static String generateCustomerId(){
        String from = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String result = "";
        for(int i=0; i<6; i++){
            char newletter = from.charAt(ThreadLocalRandom.current().nextInt(0, 36));
            result = result + newletter;
        }
        return result;
    }

    public static boolean login(){
        System.out.println("Please enter Login credentials below.\nUsername:");
        String un = scanner.next();
        System.out.println("Password:");
        String pw = scanner.next();
        if(un.equalsIgnoreCase("user") && pw.equalsIgnoreCase("password")){
            return true;
        }
        return false;
    }

    public static void delay(long interval) {
        try {
           TimeUnit.MILLISECONDS.sleep(interval);
        } catch (Exception e) {
        }

    }
    public static void createContract(Contract contract) {
        DBConnection.executeQuery("INSERT INTO rentals (fromDate, fromTime, toDate, toTime, maxKM, km, car_id, customer_id) VALUES ( \"" + contract.getFromDate() + "\", \"" +
                contract.getFromTime() + "\", \"" + contract.getToDate() + "\", \"" + contract.getToTime() + "\", " + contract.getMaxKm() + ", " + contract.getKm() + ", \"" +
                contract.getCarId() + "\", \"" + contract.getCustomerId() + "\");");
        System.out.println("\nRental contract created.");
    }

    /* public void createSMTH(){
        ResultSet rs = DBConnection.selectQuery("SELECT COLUMN FROM TABLE;");
        try{
            while(rs.next()){
                System.out.println("Name" + rs.getString(""));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }*/

    public ArrayList<Integer> getRentals(String field, String key) {
        String query = "SELECT rental_id, fromDate, fromTime, toDate, toTime, Customers.customer_id, brand, model, plate FROM Rentals" +
                " INNER JOIN Cars ON Rentals."+field+" = "+"\""+key+"\" " +
                "INNER JOIN Customers ON Rentals.customer_id = Customers.customer_id " +
                "AND Cars.car_id = Rentals.car_id;";
        ResultSet rs = DBConnection.selectQuery(query);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try{
            System.out.println("Searching results " + key + " " + field);
            printRentalResultHeader();
            while(rs.next()){
                System.out.print("|" + rs.getInt("rental_id") +"|\t");
                System.out.print("|" + rs.getString(2) +"|\t");
                System.out.print("|" + rs.getString(3) +"|\t");
                System.out.print("|" + rs.getString(4) +"|\t");
                System.out.print("|" + rs.getString(5) +"|\t");
                System.out.print("|" + rs.getInt(6) +"|\t");
                System.out.print("|" + rs.getString(7) +"|\t");
                System.out.print("|" + rs.getString(8) +"|\t");
                System.out.print("|" + rs.getString(9) +"|\t");
                System.out.println();
                ids.add(rs.getInt("rental_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ids;
    }

    public ArrayList<Integer> getRentalsByCarInfo(String field, String key) {
        String query = "SELECT rental_id, fromDate, fromTime, toDate, toTime, Customers.customer_id,brand, model, plate FROM Rentals " +
                "INNER JOIN Cars ON Cars."+field+" = "+"\""+key+"\""+
                "INNER JOIN Customers ON Rentals.customer_id = Customers.customer_id " +
                "AND Cars.car_id = Rentals.car_id;";
        ResultSet rs = DBConnection.selectQuery(query);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try{
            System.out.println("Searching results " + key + " " + field);
            printRentalResultHeader();
            while(rs.next()){
                System.out.print("|" + rs.getInt("rental_id") +"|\t");
                System.out.print("|" + rs.getString(2) +"|\t");
                System.out.print("|" + rs.getString(3) +"|\t");
                System.out.print("|" + rs.getString(4) +"|\t");
                System.out.print("|" + rs.getString(5) +"|\t");
                System.out.print("|" + rs.getInt(6) +"|\t");
                System.out.print("|" + rs.getString(7) +"|\t");
                System.out.print("|" + rs.getString(8) +"|\t");
                System.out.print("|" + rs.getString(9) +"|\t");
                System.out.println();
                ids.add(rs.getInt("rental_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ids;
    }

    public ArrayList<Integer> getCustomers(String field, String key) {
        String query = "SELECT customer_id, firstName, lastName, mobilePhone, email, driverLicenceNumber, driverSinceDate, address_id " +
                "FROM Customers WHERE " +field+" = "+"\""+key+"\";";

        ResultSet rs = DBConnection.selectQuery(query);
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try{
            System.out.println("Searching results " + key + " " + field);
            printCustomerResultHeader();
            while(rs.next()){
                System.out.print("|" + rs.getInt("customer_id") +"|\t");
                System.out.print("|" + rs.getString(2) +"|\t");
                System.out.print("|" + rs.getString(3) +"|\t");
                System.out.print("|" + rs.getString(4) +"|\t");
                System.out.print("|" + rs.getString(5) +"|\t");
                System.out.print("|" + rs.getString(6) +"|\t");
                System.out.print("|" + rs.getString(7) +"|\t");
                System.out.print("|" + rs.getInt(8) +"|\t");
                System.out.println();
                ids.add(rs.getInt("customer_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ids;
    }

    private void printCustomerResultHeader() {
        System.out.println("Customer Id|\t|FirstName|\t|LastName|\t|MobilePhone|\t|Email|\t|DriverLicenseNumber|\t|DriverSinceDate|\t\t|AddressId|\t");
    }

    public void displayCustomerAddress(int id) {
        String query = "SELECT customer_id, firstName, lastName, streetName, zipCode, city " +
                "FROM Customers INNER JOIN Addresses ON Addresses.address_id = Customers.address_id "+
                "AND Customers.customer_id = " + id + ";";
        ResultSet rs = DBConnection.selectQuery(query);
        try{
            printAddressResultHeader();
            while(rs.next()){
                System.out.print("|" + rs.getInt("customer_id") +"|\t");
                System.out.print("|" + rs.getString(2) +"|\t");
                System.out.print("|" + rs.getString(3) +"|\t");
                System.out.print("|" + rs.getString(4) +"|\t");
                System.out.print("|" + rs.getString(5) +"|\t");
                System.out.print("|" + rs.getString(6) +"|\t");
                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private void printAddressResultHeader() {
        System.out.println("Customer Id|\t|FirstName|\t|LastName|\t|StreetName|\t|ZipCode|\t|City|\t");
    }


    private void printRentalResultHeader(){
        System.out.println("Rental Id|\t|FromDate|\t|FromTime|\t|ToDate|\t|ToTime|\t|Customer_id|\t|Brand|\t\t|Model|\t\t|Plate|\t");
    }

    public boolean deleteRental(int id) {
        String query = "DELETE from Rentals WHERE rental_id = " + id + ";";
        return DBConnection.executeQuery(query);
    }

    public void updateRental(String field, String newValue, int id) {
        String query = "UPDATE Rentals SET " + field + " = \"" + newValue + "\" WHERE rental_id = " + id + ";";
        DBConnection.executeQuery(query);
    }

    public boolean deleteCustomer(int id) {
        String query = "DELETE from Rentals WHERE customer_id = " + id + ";";
        String query1 = "DELETE from Addresses WHERE address_id IN (SELECT address_id FROM Customers WHERE customer_id = " + id + ");";
        String query2 = "DELETE from Customers WHERE customer_id = " + id + ";";

        return DBConnection.executeQuery(query) && DBConnection.executeQuery(query2) && DBConnection.executeQuery(query1) ;
    }

    public void updateCustomer(String field, String newValue, int id) {
        String query = "UPDATE Customers SET "+ field + " = \"" + newValue + "\" WHERE customer_id = " + id + ";";
        DBConnection.executeQuery(query);
    }

    public void updateAddress(String field, String newValue, int id) {
        String query = "UPDATE Addresses SET "+ field + " = \"" + newValue + "\" WHERE address_id = " + id + ";";
        DBConnection.executeQuery(query);
    }

    public static void displayContracts(){
        ResultSet rs = DBConnection.selectQuery("SELECT * FROM rentals;");
        try
        {
            while (rs.next())
            {
                System.out.println("Rental ID: " + rs.getInt("rental_id") + " | "+ "Rental from date: " + rs.getString("fromDate") + " | " +
                        "Rental from time: " + rs.getString("fromTime") + " | " +
                        "Rental to date:: " + rs.getString("toDate") + " | " +
                        "Rental to time: " + rs.getString("toTime") + " | " + "Maximum km to use: " + rs.getInt("maxKM") + " | " +
                        "Current number of km: " + rs.getInt("km") + " | " + "Car ID: " + rs.getInt("car_id") + " | "+ "Customer ID: " + rs.getInt("customer_id") );
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void createCar(Car car){
        DBConnection.executeQuery("INSERT INTO Cars (brand, model, plate, regDate, odometer, fuelType, carType) VALUES" +
                "(\"" + car.getBrand() + "\", \"" + car.getModel() + "\", \"" + car.getPlate() + "\", \"" + car.getRegDate() + "\", \"" +
                car.getOdometer()+ "\", \"" + car.getFuelType() + "\", \"" + car.getCarType() + "\");");
        System.out.println("\nCar successfully created.");
    }

    public boolean deleteCar(String plate) {
        String query = "DELETE from Cars WHERE plate = " + plate + ";";
        return DBConnection.executeQuery(query);
    }

    public static void showAllCars(){
        ResultSet rs = DBConnection.selectQuery("SELECT * FROM cars;");
        try
        {
            while (rs.next())
            {
                System.out.println("Brand: " + rs.getString("brand") + " | "+ "Model: " + rs.getString("model") + " | " +
                        "Licence Plate: " + rs.getString("plate") + " | " +
                        "Registered on:: " + rs.getString("regDate") + " | " +
                        "Odometer: " + rs.getString("odometer") + " | " +
                        "Fuel Type: " + rs.getString("fuelType") + " | " +
                        "Car Type: " + rs.getString("carType"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateCarBrand(String plate, String answer){
        String query = "UPDATE from cars SET brand = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }

    public void updateCarModel(String plate, String answer){
        String query = "UPDATE from cars SET model = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }

    public void updateCarPlate(String plate, String answer){
        String query = "UPDATE from cars SET plate = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }

    public void updateCarRegDate(String plate, String answer){
        String query = "UPDATE from cars SET regDate = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }
    public void updateCarOdometer(String plate, String answer){
        String query = "UPDATE from cars SET odometer = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }

    public void updateCarFuelType(String plate, String answer){
        String query = "UPDATE from cars SET fuelType = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }

    public void updateCarType(String plate, String answer){
        String query = "UPDATE from cars SET carType = \"" + answer + "\" WHERE plate = " + plate + ";";
        DBConnection.executeQuery(query);
    }



}
