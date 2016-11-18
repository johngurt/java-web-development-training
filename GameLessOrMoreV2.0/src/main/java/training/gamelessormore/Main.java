package training.gamelessormore;

/**
 * Class that is entry point to program
 *
 * @author Hurt Yevhenii
 */
public class Main {

    public static void main(String[] args) {

        //initialization
        View view = new View();
        Controller controller = new Controller(view);

        //run
        controller.processUser();
    }
}
