import java.util.Scanner;

public class NewCarMenu {

    public static Scanner scanner = new Scanner(System.in);

    public NewCarMenu(){

        App.getController().createCar();
        new MainMenu();
    }


}
