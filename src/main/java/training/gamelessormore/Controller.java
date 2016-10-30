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

        model.setCurrentNumber(inputValueWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));
        while (! model.playerWin()) {
            if(model.unknownNumberMoreThanCurrent()) {
                view.printMessage(View.GREATER_THAN);
                model.setCurrentMinNumber(model.getCurrentNumber());
            } else {
                view.printMessage(View.LESS_THAN);
                model.setCurrentMaxNumber(model.getCurrentNumber());
            }
            model.setCurrentNumber(inputValueWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));
        }
        view.printMessage(View.CORRECT_NUMBER);
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
