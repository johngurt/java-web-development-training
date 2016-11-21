package training.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import training.initialize.Initialization;

import java.util.ArrayList;
import java.util.function.Predicate;

import static training.initialize.Initialization.*;

/**
 * Christmas box model test class
 * It contains tests for nontrivial methods of class Christmas box
 *
 * @author Hurt Yevhenii
 */
public class ChristmasBoxTest {

    private ArrayList<Sweets> content;

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
        content = new ArrayList<>();
        for(Initialization sweet : Initialization.values()) {
            content.add(sweet.getSweets());
        }

        christmasBox = new ChristmasBox("John", content);
        totalWeight = 683;

        sortedByName = new ArrayList<>();
        sortedByName.add(D.getSweets());
        sortedByName.add(A.getSweets());
        sortedByName.add(F.getSweets());
        sortedByName.add(B.getSweets());
        sortedByName.add(E.getSweets());
        sortedByName.add(C.getSweets());

        sortedByManufacturer = new ArrayList<>();
        sortedByManufacturer.add(F.getSweets());
        sortedByManufacturer.add(A.getSweets());
        sortedByManufacturer.add(D.getSweets());
        sortedByManufacturer.add(C.getSweets());
        sortedByManufacturer.add(B.getSweets());
        sortedByManufacturer.add(E.getSweets());

        sortedByWeight = new ArrayList<>();
        sortedByWeight.add(A.getSweets());
        sortedByWeight.add(B.getSweets());
        sortedByWeight.add(E.getSweets());
        sortedByWeight.add(D.getSweets());
        sortedByWeight.add(F.getSweets());
        sortedByWeight.add(C.getSweets());

        sortedBySugar = new ArrayList<>();
        sortedBySugar.add(D.getSweets());
        sortedBySugar.add(F.getSweets());
        sortedBySugar.add(E.getSweets());
        sortedBySugar.add(B.getSweets());
        sortedBySugar.add(C.getSweets());
        sortedBySugar.add(A.getSweets());

        sweetsInInterval = new ArrayList<>();
        sweetsInInterval.add(B.getSweets());
        sweetsInInterval.add(C.getSweets());
        sweetsInInterval.add(E.getSweets());

        interval = i -> (i.getSugarConcentration() >= 20 && i.getSugarConcentration() <= 60);
    }

    @Test
    public void testGetTotalWeight() throws Exception {
        Assert.assertEquals(totalWeight, christmasBox.getTotalWeight());
    }

    @Test
    public void testSortChristmasBoxByName() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_NAME);
        Assert.assertEquals(sortedByName, christmasBox.getContentOfBox());
    }

    @Test
    public void testSortChristmasBoxByManufacturer() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_MANUFACTURER);
        Assert.assertEquals(sortedByManufacturer, christmasBox.getContentOfBox());
    }

    @Test
    public void testSortChristmasBoxByWeight() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_WEIGHT);
        Assert.assertEquals(sortedByWeight, christmasBox.getContentOfBox());
    }

    @Test
    public void testSortChristmasBoxBySugar() throws Exception {
        christmasBox.sortChristmasBox(SortBy.BY_SUGAR_CONCENTRATION);
        Assert.assertEquals(sortedBySugar, christmasBox.getContentOfBox());
    }

    @Test
    public void testFindSweetsInInterval() throws Exception {
        Assert.assertEquals(sweetsInInterval, christmasBox.findSweetsInInterval(interval));
    }
}