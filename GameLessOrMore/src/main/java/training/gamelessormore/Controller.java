package training.gamelessormore;

import java.util.Scanner;

/**
 * Class that implements user interaction
 *
 * @author Hurt Yevhenii
 */
public class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    //work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setInitialMin(GlobalConstants.LEFT_BOUND);
        model.setInitialMax(GlobalConstants.RIGHT_BOUND);
        model.setUnknownNumber();
        model.setCurrentNumber(inputValueWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));
        model.addPlayersAttempt();
        while (! model.playerWin()) {
            if(model.unknownNumberMoreThanCurrent()) {
                view.printMessage(View.GREATER_THAN);
                model.setCurrentMinNumber(model.getCurrentNumber());
            } else {
                view.printMessage(View.LESS_THAN);
                model.setCurrentMaxNumber(model.getCurrentNumber());
            }
            model.setCurrentNumber(inputValueWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));
            model.addPlayersAttempt();
        }
        view.printMessage(View.CORRECT_NUMBER);
        view.printMessageWithTwoNumbers(View.START_INTERVAL, model.getInitialMin(), model.getInitialMax());
        view.printMessageWithOneNumber(View.UNKNOWN_NUMBER, model.getUnknownNumber());
        view.printMessageWithOneNumber(View.NUMBER_OF_ATTEMPTS, model.numberOfAttempts());
        view.printMessage(View.ATTEMPTS + model.printPlayersAttempts());
    }

    //Utility method that checks input data
    public int inputValueWithScanner(Scanner sc, int min, int max) {

        int inputValue;
        while(true) {
            view.printMessageWithTwoNumbers(View.INPUT_INT_DATA, min, max);
            if(sc.hasNextInt()) {
                inputValue = sc.nextInt();
                if(model.isOutOfBoundary(inputValue)) {
                    view.printMessage(View.WRONG_INPUT);
                } else {
                    break;
                }
            }
        }
        return inputValue;
    }
}
