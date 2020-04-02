import java.util.Scanner;

public class MainMenu {

    public static Scanner scanner = new Scanner(System.in);

    public MainMenu() {
        System.out.println("");
        System.out.println("Select from the following options:");
        System.out.println("[1] Create new contract.");
        System.out.println("[2] View/modify existing contracts");
        System.out.println("[3] Enter new car");
        System.out.println("[4] View/modify existing cars");
        System.out.println("[5] Exit system");

        String answer = scanner.next();

        switch (answer) {
            case "1":
                new ContractMenu();
                break;
            case "2":
                //new ModifyContractMenu();
                break;
            case "3":
                new NewCarMenu();
                break;
            case "4":
                //new ModifyCarMenu();
                break;
            case "5":
                System.out.println("Logging off...");
                System.exit(0);
            default:
                System.out.println("Incorrect choice. Please try again.");
                App.getController().delay(1200);
                new MainMenu();
        }
    }
}//class bracket
