public class App {

    private static Controller controller;

    public static void main(String[] args) {

        controller = new Controller();
        new Launch();
    }

    public static Controller getController(){
        return controller;
    }
}
