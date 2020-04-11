import java.util.Scanner;

public class ContractMenu {

    public static Scanner scanner = new Scanner(System.in);
    public static Validation validation = new Validation();

    public ContractMenu(){
        Contract temp = new Contract();
        System.out.println("New Contract menu");
        System.out.println("");
        System.out.println("Enter ID of car being rented:");
        temp.setCarId(scanner.next());
        System.out.println("Enter Customer ID");
        temp.setCustomerId(scanner.next());
        System.out.println("Enter Start Date of rental:");
        temp.setFromDate(scanner.next());
        System.out.println("Enter start time:");
        temp.setFromTime(scanner.next());
        System.out.println("Enter End date of rental:");
        temp.setToDate(scanner.next());
        System.out.println("Enter end time:");
        temp.setToTime(scanner.next());
        System.out.println("Enter maximum distance to be driven:");
        temp.setMaxKm(scanner.next());
        System.out.println("Enter current mileage from car");
        temp.setOdometer(scanner.next());
        System.out.println(temp.toStringConsole());
        System.out.println("Type [1] if details are correct, or [2] to cancel:");
        String answer = scanner.next();
        switch (answer) {
            case "1":
                //do what we gon do w/ saving
                new MainMenu();
                break;
            case "2":
                new MainMenu();
                break;
        }
    }

    public static void updateExistingContract(){
        String choice = "-1";
        do{
        System.out.println("By which field would you like to search for the rental information?");
        System.out.println("1. Rental information (start date, model type, etc. )");
        System.out.println("2. Customer information");
        System.out.println("3. Go back");
        choice = scanner.next();
        switch(choice){
            case "1":
                App.getController().findRentalAndUpdate();
                break;
            case "2":
                App.getController().findCustomerAndUpdate();
                break;
        }
        }while(!choice.equals("3"));
        new MainMenu();
    }


    private static void findCustomer() {
    }
}
