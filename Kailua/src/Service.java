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
