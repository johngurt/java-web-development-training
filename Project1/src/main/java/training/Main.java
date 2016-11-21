package training;

import training.controller.Controller;
import training.view.View;

/**
 * Class that contains point of entry to program
 *
 * @author Hurt Yevhenii
 */
public class Main {
    public static void main( String[] args ) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.processUser();
    }
}
