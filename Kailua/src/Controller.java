public class Controller {

    private static Service service = new Service();

    public Controller(){
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
