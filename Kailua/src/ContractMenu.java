import java.util.Scanner;

public class ContractMenu {

    public static Scanner scanner = new Scanner(System.in);
    public static Validation validation = new Validation();

    public ContractMenu(){
        App.getController().createContract();
        new MainMenu();
    }
    public static void displayContract(){
        App.getController().displayContracts();
        System.out.println();
        new MainMenu();
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
