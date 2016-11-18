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
    String forExit = "q";

    Controller(View view) {
        this.view = view;
    }

    //work method
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        int leftBoundary;
        int rightBoundary;
        int value;

        view.printMessage(View.INPUT_INITIAL_MIN);
        leftBoundary = inputNumberWithScanner(sc);
        view.printMessageWithOneNumber(View.INPUT_INITIAL_MAX, leftBoundary + 1);
        do {
            rightBoundary = inputNumberWithScanner(sc);
            if(rightBoundary <= leftBoundary + 1) {
                view.printMessage(View.WRONG_INPUT);
                view.printMessageWithOneNumber(View.INPUT_INITIAL_MAX, leftBoundary + 1);
                view.printMessage(View.FOR_EXIT);
            }
        } while (rightBoundary <= leftBoundary + 1);

        model = new Model(leftBoundary, rightBoundary);

        model.setUnknownNumber();

        do {
            view.printMessageWithTwoNumbers(View.INPUT_INT_DATA, model.getCurrentMinNumber(), model.getCurrentMaxNumber());
            view.printMessage(View.FOR_EXIT);
            value = tryToGuessNumberWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber());
            if(model.isOutOfBoundary(value)) {
                view.printMessage(View.WRONG_INPUT);
            }
        } while (model.isOutOfBoundary(value));

        model.setCurrentNumber(value);
        model.addPlayersAttempt();

        while (! model.playerWin()) {
            if(model.unknownNumberMoreThanCurrent()) {
                view.printMessage(View.GREATER_THAN);
                model.setCurrentMinNumber(model.getCurrentNumber());
            } else {
                view.printMessage(View.LESS_THAN);
                model.setCurrentMaxNumber(model.getCurrentNumber());
            }
            do {
                view.printMessageWithTwoNumbers(View.INPUT_INT_DATA, model.getCurrentMinNumber(), model.getCurrentMaxNumber());
                view.printMessage(View.FOR_EXIT);
                value = tryToGuessNumberWithScanner(sc, model.getCurrentMinNumber(), model.getCurrentMaxNumber());
            } while (model.isOutOfBoundary(value));
            model.setCurrentNumber(value);
            model.addPlayersAttempt();
        }
        view.printMessage(View.CORRECT_NUMBER);
        view.printMessageWithTwoNumbers(View.START_INTERVAL, model.getInitialMin(), model.getInitialMax());
        view.printMessageWithOneNumber(View.UNKNOWN_NUMBER, model.getUnknownNumber());
        view.printMessageWithOneNumber(View.NUMBER_OF_ATTEMPTS, model.numberOfAttempts());
        view.printMessage(View.ATTEMPTS + model.printPlayersAttempts());
    }

    //Utility method that checks input data
    public int tryToGuessNumberWithScanner(Scanner sc, int min, int max) {
        int inputValue;

        while(!sc.hasNextInt()) {
            if(sc.next().equals(forExit)) {
                System.exit(0);
            } else {
                view.printMessage(View.WRONG_INPUT);
                view.printMessageWithTwoNumbers(View.INPUT_INT_DATA, min, max);
                view.printMessage(View.FOR_EXIT);
            }
        }

        inputValue = sc.nextInt();
        return inputValue;
    }

    public int inputNumberWithScanner(Scanner sc) {
        int boundary;

        view.printMessage(View.FOR_EXIT);

        while (!sc.hasNextInt()) {
            if(sc.next().equals(forExit)) {
                System.exit(0);
            } else {
                view.printMessage(View.WRONG_INPUT);
                view.printMessage(View.INPUT_INTEGER_NUMBER);
                view.printMessage(View.FOR_EXIT);
            }
        }

        boundary = sc.nextInt();
        return boundary;
    }
}
