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

    /* public void createSMTH(){
        ResultSet rs = DBConnection.selectQuery("SELECT COLUMN FROM TABLE;");
        try{
            while(rs.next()){
                System.out.println("Name" + rs.getString(""));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insertSMTH(){
        DBConnection.executeQuery("INSERT INTO COLUMN (date, time, child_id, teacher_id) VALUES\n" +
                "(\"" + s + "\"," + m + "," + t + "," + h + ");");
    }
    */



}
