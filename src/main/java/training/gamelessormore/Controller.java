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

    //work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setCurrentNumber(inputValueWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));
        model.addPlayersAttempt();
        while (! model.playerWin()) {
            if(model.unknownNumberMoreThanCurrent()) {
                view.printMessage(View.GREATER_THAN);
                model.setCurrentMinNumber(model.getCurrentNumber() + 1);
            } else {
                view.printMessage(View.LESS_THAN);
                model.setCurrentMaxNumber(model.getCurrentNumber() - 1);
            }
            model.setCurrentNumber(inputValueWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber()));
            model.addPlayersAttempt();
        }
        view.printMessage(View.CORRECT_NUMBER);
        view.printMessageWithTwoNumbers(View.START_INTERVAL, model.getMIN_RAND(), model.getMAX_RAND());
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
