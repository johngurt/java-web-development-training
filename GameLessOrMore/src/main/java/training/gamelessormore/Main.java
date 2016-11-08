package training.gamelessormore;

/**
 * Created by gurt on 10/30/16.
 */
public class Main {

    public static void main(String[] args) {

        //initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //run
        controller.processUser();
    }
}