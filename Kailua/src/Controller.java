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
    public static void createContract(){
        String carId = validation.getValidatedId("Enter car Id: ");
        String customerId = validation.getValidatedId("Enter customer Id: ");
        String dateFrom = validation.getValidatedDate("Enter starting date of contract: ");
        String dateTo = validation.getValidatedDate("Enter ending date of contract: ");
        String fromTime =  validation.getValidatedTime("Enter starting time of contract: ");
        String toTime =  validation.getValidatedTime("Enter ending time of contract: ");
        int maxKm = validation.getValidatedInt("Enter maximum number of kilometers to use: ");
        int km = validation.getValidatedInt("Enter how many kilometers car already have: ");
        Contract contract = new Contract(carId, customerId, dateFrom, fromTime, dateTo, toTime, maxKm, km );
        service.createContract(contract);
    }
    public static void displayContracts(){
        service.displayContracts();
    }
    public static String generateEmployeeId() {
        return service.generateCustomerId();
    }

    public static void createCar(){
        String brand = validation.getValidatedString("Enter car brand:");
        String model = validation.getValidatedString("Enter car model:");
        String plate = validation.getValidatedString("Enter car plate:");
        String regDate = validation.getValidatedString("Enter car registration date:");
        String odometer = validation.getValidatedString("Enter car odometer:");
        String fuelType = validation.getValidatedString("Enter car fuel type:");
        Car car = new Car(brand, model, plate, regDate, odometer, fuelType);
        service.createCar(car);
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

    public void findCustomerAndUpdate() {
        String choice = "-1";
        ArrayList<Integer> ids = new ArrayList<Integer>();
        do{
            System.out.println("Which fields would you like to search by?");
            System.out.println("1. FirstName");
            System.out.println("2. LastName");
            System.out.println("3. Mobile phone");
            System.out.println("4. email");
            System.out.println("5. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    String firstName = validation.getValidatedName("What is the first name you are looking for?");
                    ids = searchForCustomers("firstName", firstName);
                    break;
                case "2":
                    String lastName = validation.getValidatedName("What is the last name you are looking for?");
                    ids = searchForCustomers("lastName", lastName);
                    break;
                case "3":
                    String mobilePhone = validation.getValidatedPhone("What is the phone number?");
                    ids = searchForCustomers("mobilePhone", mobilePhone);
                    break;
                case "4":
                    String email = validation.getValidatedEmail("What is the email address?");
                    ids = searchForCustomers("email", email);
                    break;
            }
            if(ids.size() > 0){
                updateOrDeleteCustomer(ids);
            }else{
                System.out.println("There are no results");
            }
        }while(!choice.equals("5"));
        ContractMenu.updateExistingContract();
    }

    private void updateOrDeleteCustomer(ArrayList<Integer> ids) {
        String choice = "-1";
        int id;
        do{
            System.out.println("What would you like to do next?");
            System.out.println("1. Update Customer information");
            System.out.println("2. Update Customer address");
            System.out.println("3. Delete Customer");
            System.out.println("4. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    id = validation.getValidatedIntFromRange("Write down id of a customer you want to update: " + ids.toString(), ids);
                    updateCustomer(id);
                    break;
                case "2":
                    id = validation.getValidatedIntFromRange("Write down the customer id, whose address you want to update: " + ids.toString(), ids);
                    updateCustomersAddress(id);
                    break;
                case "3":
                    id = validation.getValidatedIntFromRange("Write down the customer's id you want to delete " + ids.toString(), ids);
                    if(service.deleteCustomer(id)){
                        System.out.println("Customer has been successfully deleted.");
                    }
                    break;
            }
        }while(!choice.equals("4"));
        findCustomerAndUpdate();
    }

    private void updateCustomersAddress(int id) {
        String choice = "-1";
        ArrayList<Integer> ids = new ArrayList<Integer>();
        do{
            service.displayCustomerAddress(id);
            System.out.println("Which fields would you like to update?");
            System.out.println("1. StreetName");
            System.out.println("2. Zipcode");
            System.out.println("3. City");
            System.out.println("4. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    System.out.println("What is the new street name? ");
                    String streetName = scanner.next();
                    service.updateAddress("streetName", streetName, id);
                    break;
                case "2":
                    System.out.println("What is the new zipcode? ");
                    String zipCode = scanner.next();
                    service.updateAddress("zipCode", zipCode, id);
                    break;
                case "3":
                    System.out.println("What is the new city? ");
                    String city = scanner.next();
                    service.updateAddress("city", city, id);
                    break;
            }
        }while(!choice.equals("4"));
        findCustomerAndUpdate();
    }

    private void updateCustomer(int id) {
        String choice = "-1";
        ArrayList<Integer> ids = new ArrayList<Integer>();
        do{
            System.out.println("Which fields would you like to update?");
            System.out.println("1. FirstName");
            System.out.println("2. LastName");
            System.out.println("3. Mobile phone");
            System.out.println("4. email");
            System.out.println("5. driverLicenceNumber");
            System.out.println("6. driverSinceDate");
            System.out.println("7. Go back");
            choice = scanner.next();
            switch(choice){
                case "1":
                    String firstName = validation.getValidatedName("Write down new firstName for the Customer");
                    service.updateCustomer("firstName", firstName, id);
                    break;
                case "2":
                    String lastName = validation.getValidatedName("What is the last name you are looking for?");
                    service.updateCustomer("lastName", lastName, id);
                    break;
                case "3":
                    String mobilePhone = validation.getValidatedPhone("What is the new phone number?");
                    service.updateCustomer("mobilePhone", mobilePhone, id);
                    break;
                case "4":
                    String email = validation.getValidatedEmail("What is the new email address?");
                    service.updateCustomer("email", email, id);
                    break;
                case "5":
                    String driverLicenceNumber = validation.getValidatedLicenceNumber("What is the new licence number? [XXXXX-XX-XXXX]");
                    service.updateCustomer("driverLicenceNumber", driverLicenceNumber, id);
                    break;
                case "6":
                    String driverSinceDate = validation.getValidatedDate("What is the new driver since date?");
                    service.updateCustomer("driverSinceDate", driverSinceDate, id);
                    break;
            }
        }while(!choice.equals("7"));
        findCustomerAndUpdate();
    }

    private ArrayList<Integer> searchForCustomers(String field, String key) {
        return service.getCustomers(field, key);
    }
}
