package training.model;

/**
 * Entity of chocolate candies
 *
 * @author Hurt Yevhenii
 */
public class ChocolateCandies extends Sweets {

    /**
     * Type of chocolate from which candy made
     */
    private ChocolateType chocolateType;

    /**
     * Initialize base fields of Pastry and it's parent Sweets
     *
     * @param nameOfSweet name of sweet
     * @param manufacturer name of company that manufactures this sweet
     * @param weight sweet's weight in grams
     * @param sugarConcentration concentration of sugar in 100 grams of sweet
     * @param chocolateType
     */
    public ChocolateCandies(String nameOfSweet, String manufacturer, int weight, int sugarConcentration, ChocolateType chocolateType) {
        super(nameOfSweet, manufacturer, weight, sugarConcentration);
        this.chocolateType = chocolateType;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChocolateCandies)) return false;
        if (!super.equals(o)) return false;

        ChocolateCandies that = (ChocolateCandies) o;

        return chocolateType == that.chocolateType;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + chocolateType.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ChocolateCandies{" +
                super.toString() +
                ", chocolateType=" + chocolateType +
                '}';
    }
}
