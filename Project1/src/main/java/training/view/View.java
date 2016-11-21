package training.view;

/**
 * This class contains constant strings and method for printing messages
 *
 * @author Hurt Yevhenii
 */
public class View {
    //String constants
    public static final String CREATED = "Christmas box created:";
    public static final String SORT_BY_NAME = "Christmas box sorted by name:";
    public static final String SORT_BY_MANUFACTURER = "Christmas box sorted by manufacturer:";
    public static final String SORT_BY_WEIGHT = "Christmas box sorted by weight:";
    public static final String SORT_BY_SUGAR_CONCENTRATION = "Christmas box sorted by concentration of sugar:";
    public static final String EMPTY_STRING = "";
    public static final String FIND_IN_INTERVAL = "Content of Christmas box that get to the interval:";


    /**
     * Method that displays message
     *
     * @param message string that will be displayed
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
