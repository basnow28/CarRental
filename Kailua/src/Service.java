import java.util.Scanner;
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
    public static void createContract(Contract contract){
        DBConnection.executeQuery("INSERT INTO rentals (fromDate, fromTime, toDate, toTime, maxKM, km, car_id, customer_id) VALUES ( \"" +  contract.getFromDate()  + "\", \"" +
                contract.getFromTime() + "\", \"" + contract.getToDate() + "\", \"" + contract.getToTime() + "\", " + contract.getMaxKm() + ", " + contract.getKm() + ", \"" +
                contract.getCarId() + "\", \"" + contract.getCustomerId() + "\");");
        System.out.println ("\nRental contract created.");
    }
    /*public void insertSMTH(){
        DBConnection.executeQuery("INSERT INTO COLUMN (date, time, child_id, teacher_id) VALUES\n" +
                "(\"" + s + "\"," + m + "," + t + "," + h + ");");
    }
    */
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

    public static void createCar(Car car){
        DBConnection.executeQuery("INSERT INTO Cars (brand, model, plate, regDate, odometer, fuelType) VALUES" +
                "(\"" + car.getBrand() + "\", \"" + car.getModel() + "\", \"" + car.getPlate() + "\", \"" + car.getRegDate() + "\", \"" +
                car.getOdometer()+ "\", \"" + car.getFuelType() + "\");");
        System.out.println("\nCar successfully created.");
    }



}
