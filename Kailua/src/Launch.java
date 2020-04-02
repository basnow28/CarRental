public class Launch {

    public Launch(){

        System.out.println("Welcome to Kailua car rental");
        while(!App.getController().login()){
            System.out.println("Incorrect credentials. Please try again.");
            App.getController().login();
        }
        new MainMenu();

    }



}
