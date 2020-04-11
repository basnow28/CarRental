import java.util.*;

public class Controller {

    private static Service service;
    private static Validation validation;
    private static Scanner scanner;

    public Controller(){
        service = new Service();
        validation = new Validation();
        scanner = new Scanner(System.in);
    }

    public static String generateEmployeeId() {
        return service.generateCustomerId();
    }

    public static boolean login(){
        return service.login();
    }

    public static void delay(long interval) {
        service.delay(interval);
    }


    public void findRentalAndUpdate() {
        String choice = "-1";
        ArrayList<Integer> ids = new ArrayList<Integer>();
        do{
            System.out.println("Which fields would you like to search by?");
            System.out.println("1. From date");
            System.out.println("2. End date");
            System.out.println("3. Car brand");
            System.out.println("4. Car plate");
            System.out.println("5. Customer information");
            System.out.println("6. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    String fromDate = validation.getValidatedDate("What is the starting date? [DD.MM.YY]");
                    ids = searchForRental("fromDate", fromDate);
                    break;
                case "2":
                    String toDate = validation.getValidatedDate("What is the starting date? [DD.MM.YY]");
                    ids = searchForRental("toDate",toDate);
                    break;
                case "3":
                    System.out.println("What is the brand you are looking for?");
                    String brand = scanner.next();
                    ids = searchForRentalByCarInfo("brand",brand);
                    break;
                case "4":
                    System.out.println("What is the plate you are looking for?");
                    String plate = scanner.next();
                    ids = searchForRentalByCarInfo("plate",plate);
                    break;
            }
            if(ids.size() > 0){
                updateOrDeleteRental(ids);
            }else{
                System.out.println("There are no results");
            }
        }while(!choice.equals("6"));
        ContractMenu.updateExistingContract();
    }

    private void updateOrDeleteRental(ArrayList<Integer> ids) {
        String choice = "-1";
        int id;
        do{
            System.out.println("What would you like to do next?");
            System.out.println("1. Update Rental information");
            System.out.println("2. Delete Rental");
            System.out.println("3. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    id = validation.getValidatedIntFromRange("Write down id of rental you want to update: " + ids.toString(), ids);
                    updateRental(id);
                    break;
                case "2":
                    id = validation.getValidatedIntFromRange("Write down id of rental you want to delete: " + ids.toString(), ids);
                    if(service.deleteRental(id)){
                        System.out.println("Rental has been successfully deleted.");
                    }
                    break;
            }
        }while(!choice.equals("3"));
        findRentalAndUpdate();
    }

    private void updateRental(int id) {
        String choice = "-1";
        do{
            System.out.println("What field do you want to update?");
            System.out.println("1. From date");
            System.out.println("2. From time");
            System.out.println("3. To date");
            System.out.println("4. To time");
            System.out.println("5. Car - [in progress]");
            System.out.println("6. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    String fromDate = validation.getValidatedDate("What is a new rental start date?");
                    service.updateRental("fromDate", fromDate, id);
                    break;
                case "2":
                    String fromTime = validation.getValidatedTime("What is a new rental start time?");
                    service.updateRental("fromTime", fromTime, id );
                    break;
                case "3":
                    String toDate = validation.getValidatedDate("What is a new rental end date?");
                    service.updateRental("toDate", toDate, id);
                    break;
                case "4":
                    String toTime = validation.getValidatedTime("What is a new rental end time?");
                    service.updateRental("toTime", toTime, id);
                    break;
            }
        }while(!choice.equals("6"));
        findRentalAndUpdate();
    }


    private ArrayList<Integer> searchForRental(String field, String key) {
        return service.getRentals(field, key);
    }

    private ArrayList<Integer> searchForRentalByCarInfo(String brand, String key) {
        return service.getRentalsByCarInfo(brand, key);
    }

}
