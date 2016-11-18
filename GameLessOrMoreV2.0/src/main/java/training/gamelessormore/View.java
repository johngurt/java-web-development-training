package training.gamelessormore;

/**
 * Class that contains all string constants for interaction with user
 * and methods that implements information output
 *
 * @author Hurt Yevhenii
 */
public class View {

    //String constants
    public static final String INPUT_INTEGER_NUMBER = "Please enter integer number";
    public static final String INPUT_INITIAL_MIN = "Please enter integer number that will be left boundary";
    public static final String INPUT_INITIAL_MAX = "Please enter integer number that will be right boundary. It should be more than %s";
    public static final String FOR_EXIT = "You can enter 'q' for exit";
    public static final String INPUT_INT_DATA = "Please input integer value from %s to %s exclusive";
    public static final String WRONG_INPUT = "Wrong input!";
    public static final String GREATER_THAN = "Unknown number is more";
    public static final String LESS_THAN = "Unknown number is less";
    public static final String CORRECT_NUMBER = "You win";
    public static final String NUMBER_OF_ATTEMPTS = "You took %s attempts";
    public static final String UNKNOWN_NUMBER = "Unknown number was %s";
    public static final String ATTEMPTS = "They were: ";
    public static final String START_INTERVAL = "Program could make a number between %s and %s exclusive";

    /**
     * Prints string with two numbers that passed as arguments
     * and then terminated the line
     *
     * @param message string to be printed
     * @param first first number that will be substituted to string
     * @param second second number that will be substituted to string
     */
    public void printMessageWithTwoNumbers(String message, int first, int second) {
        System.out.printf(message, first, second);
        System.out.println();
    }

    /**
     * Prints string with one number that passed as arguments
     * and then terminated the line
     *
     * @param message string to be printed
     * @param num number that will be substituted to string
     */
    public void printMessageWithOneNumber(String message, int num) {
        System.out.printf(message, num);
        System.out.println();
    }

    /**
     * Prints string and then terminated the line
     *
     * @param message string to be printed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
