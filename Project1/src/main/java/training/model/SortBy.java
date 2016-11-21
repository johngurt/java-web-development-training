package training.model;

import java.util.Comparator;

/**
 * enum of sorting types
 *
 * @author Hurt Yevhenii
 */
public enum SortBy {

    /**
     * Sort sweets by their weight
     */
    BY_WEIGHT(Comparator.comparing(Sweets::getWeight)),
    /**
     * Sort sweets by concentration of sugar
     */
    BY_SUGAR_CONCENTRATION(Comparator.comparing(Sweets::getSugarConcentration)),
    /**
     * Sort sweets by manufacturer
     */
    BY_MANUFACTURER(Comparator.comparing(Sweets::getManufacturer)),
    /**
     * Sort sweets by their names
     */
    BY_NAME(Comparator.comparing(Sweets::getNameOfSweet));

    private Comparator<Sweets> comparator;

    SortBy(Comparator<Sweets> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Sweets> getComparator() {
        return comparator;
    }
}
