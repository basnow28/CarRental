import java.util.Scanner;

public class ModifyCarMenu {

    public static Scanner scanner = new Scanner(System.in);

    public ModifyCarMenu(){

        System.out.println("Please select an option:");
        System.out.println("[1] Show all cars, [2] Modify existing car, [3] Delete existing car, [or [4] to exit to Main Menu");
        String answer = scanner.next();
        switch (answer){
            case "1":
                App.getController().showAllCars();
                new ModifyCarMenu();
                break;
            case "2":
                App.getController().modifyCar();
                new ModifyCarMenu();
                break;
            case "3":
                App.getController().deleteCar();
                new ModifyCarMenu();
                break;
            case "4":
                new MainMenu();
                break;

        }



    }
}
