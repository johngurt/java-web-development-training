package training.controller;

import training.model.*;
import training.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Class that implements Controller unit
 *
 * @author Hurt Yevhenii
 */
public class Controller {

    /**
     * Reference to view component
     */
    private View view;

    /**
     * Reference to model component
     */
    private ChristmasBox christmasBox;

    /**
     * Constructor with one parameter
     *
     * @param view reference to view component
     */
    public Controller(View view) {
        this.view = view;
    }

    /**
     * Constructor with two parameters
     *
     * @param view reference to view component
     * @param christmasBox reference to model component
     */
    public Controller(View view, ChristmasBox christmasBox) {
        this.view = view;
        this.christmasBox = christmasBox;
    }

    /**
     * Method that run program cycle
     */
    public void processUser() {
        /*Create instance of Christmas box*/
        List<Sweets> listOfSweets = initialData();
        christmasBox = new ChristmasBox("John", listOfSweets);

        /*Display content of Christmas box*/
        view.printMessage(View.CREATED);
        view.printMessage(christmasBox.toString());

        /*Sort content of box by different parameters*/
        view.printMessage(View.EMPTY_STRING);
        view.printMessage(View.SORT_BY_NAME);
        christmasBox.sortChristmasBox(SortBy.BY_NAME);
        view.printMessage(christmasBox.toString());

        view.printMessage(View.EMPTY_STRING);
        view.printMessage(View.SORT_BY_MANUFACTURER);
        christmasBox.sortChristmasBox(SortBy.BY_MANUFACTURER);
        view.printMessage(christmasBox.toString());

        view.printMessage(View.EMPTY_STRING);
        view.printMessage(View.SORT_BY_WEIGHT);
        christmasBox.sortChristmasBox(SortBy.BY_WEIGHT);
        view.printMessage(christmasBox.toString());

        view.printMessage(View.EMPTY_STRING);
        view.printMessage(View.SORT_BY_SUGAR_CONCENTRATION);
        christmasBox.sortChristmasBox(SortBy.BY_SUGAR_CONCENTRATION);
        view.printMessage(christmasBox.toString());

        /*Find sweets in content of Christmas box that get to the interval*/
        view.printMessage(View.EMPTY_STRING);
        view.printMessage(View.FIND_IN_INTERVAL);
        Predicate<Sweets> interval = i -> (i.getSugarConcentration() >= 20 && i.getSugarConcentration() <= 60);
        view.printMessage(christmasBox.printContentOfBox(christmasBox.findSweetsInInterval(interval)));
    }

    private List<Sweets> initialData() {
        List<Sweets> result = new ArrayList<>();
        result.add(new ChocolateCandies("Jack", "Konti", 50, 62, ChocolateType.BLACK));
        result.add(new ChocolateCandies("Snackfood", "Mars", 88, 48, ChocolateType.MILK));
        result.add(new ChocolateCandies("Truffles", "Lindor", 200, 55, ChocolateType.WHITE));
        result.add(new Pastry("Croissant", "Kulinichi", 120, 11, TypeOfFlour.WHITE));
        result.add(new Pastry("Strudel", "Wrights", 100, 25, TypeOfFlour.WHOLE_WHEAT));
        result.add(new Pastry("Puff", "Baker Street", 125, 13, TypeOfFlour.WHITE_WITH_GERM));
        return result;
    }
}