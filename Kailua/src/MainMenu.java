import java.util.Scanner;

public class MainMenu {

    public static Scanner scanner = new Scanner(System.in);

    public MainMenu() {
        System.out.println("");
        System.out.println("Select from the following options:");
        System.out.println("[1] Create contracts");
        System.out.println("[2] View contracts");
        System.out.println("[3] Modify existing contracts");
        System.out.println("[4] Enter new car");
        System.out.println("[5] View/modify existing cars");
        System.out.println("[6] Exit system");

        String answer = scanner.next();

        switch (answer) {
            case "1":
                new ContractMenu();
                break;
            case "2":
                ContractMenu.displayContract();
            case "3":
                ContractMenu.updateExistingContract();
                break;
            case "4":
                //new NewCarMenu();
                break;
            case "5":
                //new ModifyCarMenu();
                break;
            case "6":
                System.out.println("Logging off...");
                System.exit(0);
            default:
                System.out.println("Incorrect choice. Please try again.");
                App.getController().delay(1200);
                new MainMenu();
        }
    }
}//class bracket
