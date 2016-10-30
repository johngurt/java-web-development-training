package training.gamelessormore;

/**
 * Created by gurt on 10/30/16.
 */
public class View {

    public static final String INPUT_INT_DATA = "Please input integer value from %s to %s";
    public static final String WRONG_INPUT = "Wrong input!";
    public static final String GREATER_THAN = "Unknown number is more";
    public static final String LESS_THAN = "Unknown number is less";
    public static final String CORRECT_NUMBER = "You win";
    public static final String NUMBER_OF_ATTEMPTS = "You took %s attempts";
    public static final String UNKNOWN_NUMBER = "Unknown number was %s";
    public static final String ATTEMPTS = "They were: ";
    public static final String START_INTERVAL = "Program could make a number between %s and %s";

    public void printMessageWithTwoNumbers(String message, int min, int max) {
        System.out.printf(message, min, max);
        System.out.println();
    }

    public void printMessageWithOneNumber(String message, int num) {
        System.out.printf(message, num);
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
