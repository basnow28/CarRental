import java.util.Scanner;

public class RentalContractMenu {

    public static Scanner scanner = new Scanner(System.in);

    public RentalContractMenu() {
        System.out.println("");
        System.out.println("Select from the following options:");
        System.out.println("[1] Create new contract");
        System.out.println("[2] View contracts");
        System.out.println("[3] Modify contract");
        System.out.println("[4] Delete contract");
        System.out.println("[5] Main menu");

        String answer = scanner.next();

        switch (answer) {
            case "1":
                App.getController().createContract();
                break;
            case "2":
                //
                break;
            case "3":
                //
                break;
            case "4":
                //
                break;
            case "5":
                new MainMenu();
            default:
                System.out.println("Incorrect choice. Please try again.");
                App.getController().delay(1200);
                new RentalContractMenu();
        }
    }
}//class bracket