package training.gamelessormore;

import java.util.Scanner;

/**
 * Created by gurt on 10/30/16.
 */
public class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);

        
    }

    public int inputValueWithScanner(Scanner sc, int min, int max) {

        int inputValue;
        while(true) {
            view.printMessageAboutInput(View.INPUT_INT_DATA, min, max);
            if(sc.hasNextInt()) {
                inputValue = sc.nextInt();
                if(inputValue < min || inputValue > max) {
                    view.printMessage(View.WRONG_INPUT);
                } else {
                    break;
                }
            }
        }
        return inputValue;
    }
}
