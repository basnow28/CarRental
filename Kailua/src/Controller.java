public class Controller {

    private static Service service = new Service();
    private static Validation validation = new Validation(); // can I do that???
    public Controller(){
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

    public static boolean login(){
        return service.login();
    }

    public static void delay(long interval) {
        service.delay(interval);
    }




    }
