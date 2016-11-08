package training.gamelessormore;

/**
 * Class that is entry point to programm
 *
 * @author Hurt Yevhenii
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
