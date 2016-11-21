package training.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Christmas box model test class
 * It contains tests for nontrivial methods of class Christmas box
 *
 * @author Hurt Yevhenii
 */
public class ChristmasBoxTest extends TestCase {

    private ArrayList<Sweets> content = new ArrayList<Sweets>() {{
        add(new ChocolateCandies("Jack", "Konti", 50, 62, ChocolateType.BLACK));
        add(new ChocolateCandies("Snackfood", "Mars", 88, 48, ChocolateType.MILK));
        add(new ChocolateCandies("Truffles", "Lindor", 200, 55, ChocolateType.WHITE));
        add(new Pastry("Croissant", "Kulinichi", 120, 11, TypeOfFlour.WHITE));
        add(new Pastry("Strudel", "Wrights", 100, 25, TypeOfFlour.WHOLE_WHEAT));
        add(new Pastry("Puff", "Baker Street", 125, 13, TypeOfFlour.WHITE_WITH_GERM));
    }};

    private int totalWeight;

    private ArrayList<Sweets> sortedByName;
    private ArrayList<Sweets> sortedByManufacturer;
    private ArrayList<Sweets> sortedByWeight;
    private ArrayList<Sweets> sortedBySugar;

    private ArrayList<Sweets> sweetsInInterval;

    private ChristmasBox christmasBox;

    Predicate<Sweets> interval;

    @Before
    public void setUp() {
        christmasBox = new ChristmasBox("John", content);
        totalWeight = 683;

        sortedByName = new ArrayList<>();
        sortedByName.add(content.get(3));
        sortedByName.add(content.get(0));
        sortedByName.add(content.get(5));
        sortedByName.add(content.get(1));
        sortedByName.add(content.get(4));
        sortedByName.add(content.get(2));

        sortedByManufacturer = new ArrayList<>();
        sortedByManufacturer.add(content.get(5));
        sortedByManufacturer.add(content.get(0));
        sortedByManufacturer.add(content.get(3));
        sortedByManufacturer.add(content.get(2));
        sortedByManufacturer.add(content.get(1));
        sortedByManufacturer.add(content.get(4));

        sortedByWeight = new ArrayList<>();
        sortedByWeight.add(content.get(0));
        sortedByWeight.add(content.get(1));
        sortedByWeight.add(content.get(4));
        sortedByWeight.add(content.get(3));
        sortedByWeight.add(content.get(5));
        sortedByWeight.add(content.get(2));

        sortedBySugar = new ArrayList<>();
        sortedBySugar.add(content.get(3));
        sortedBySugar.add(content.get(5));
        sortedBySugar.add(content.get(4));
        sortedBySugar.add(content.get(1));
        sortedBySugar.add(content.get(2));
        sortedBySugar.add(content.get(0));

        sweetsInInterval = new ArrayList<>();
        sweetsInInterval.add(content.get(1));
        sweetsInInterval.add(content.get(2));
        sweetsInInterval.add(content.get(4));

        interval = i -> (i.getSugarConcentration() >= 20 && i.getSugarConcentration() <= 60);
    }

    @Test
    public void testGetTotalWeight() throws Exception {
        assertEquals(totalWeight, christmasBox.getTotalWeight());
    }

    @Test
    public void testSortChristmasBoxByName() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_NAME);
        assertEquals(sortedByName, christmasBox.getContentOfBox());
    }

    @Test
    public void testSortChristmasBoxByManufacturer() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_MANUFACTURER);
        assertEquals(sortedByManufacturer, christmasBox.getContentOfBox());
    }

    @Test
    public void testSortChristmasBoxByWeight() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_WEIGHT);
        assertEquals(sortedByWeight, christmasBox.getContentOfBox());
    }

    @Test
    public void testSortChristmasBoxBySugar() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_SUGAR_CONCENTRATION);
        assertEquals(sortedBySugar, christmasBox.getContentOfBox());
    }

    @Test
    public void testFindSweetsInInterval() throws Exception {
        assertEquals(sweetsInInterval, christmasBox.findSweetsInInterval(interval));
    }
}