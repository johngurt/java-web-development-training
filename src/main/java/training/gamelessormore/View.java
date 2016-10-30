package training.gamelessormore;

/**
 * Created by gurt on 10/30/16.
 */
public class View {

    public static final String INPUT_INT_DATA = "Please input integer value from %s to %s";
    public static final String WRONG_INPUT = "Wrong input!";
    public static final String WRONG_NUMBER = "Wrong number!";
    public static final String GREATER_THAN = "Number you need is more";
    public static final String LESS_THAN = "Number you need is less";
    public static final String RIGHT_NUMBER = "You win";

    public void printMessageAboutInput(String message, int from, int to) {
        System.out.printf(message, from, to);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
