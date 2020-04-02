import java.util.Scanner;

public class NewCarMenu {

    public static Scanner scanner = new Scanner(System.in);

    public NewCarMenu(){

        Car temp = new Car();

        System.out.println("Enter new car Menu");
        System.out.println("");
        System.out.println("Enter brand (e.g. Ford):");
        temp.setBrand(scanner.next());
        System.out.println("Enter model (e.g. Fiesta):");
        temp.setModel(scanner.next());
        System.out.println("Enter licence plate (format XX 12345");
        temp.setPlate(scanner.next());
        System.out.println("Enter date of registration:");
        temp.setRegDate(scanner.next());
        temp.setOdometer("0");
        System.out.println("Enter fuel type needed (e.g. diesel):");
        temp.setFuelType(scanner.next());
        System.out.println(temp.toStringConsole());
        System.out.println("Type [1] if details are correct, or [2] to cancel:");
        String answer = scanner.next();
        switch (answer){
            case "1":
                //do what we gon do w/ saving
                new MainMenu();
                break;
            case "2":
                new MainMenu();
                break;

        }









    }

}
