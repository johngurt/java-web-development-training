package training.model;

/**
 * This class represents common state and functionality of sweets entity
 *
 * @author Hurt Yevhenii
 */
public abstract class Sweets {

    /**
     * Name of the sweet
     */
    protected String nameOfSweet;
    /**
     * Company that manufactures sweet
     */
    protected String manufacturer;
    /**
     * Weight of the sweet that measured in grams
     */
    protected int weight;
    /**
     * Concentration of sugar in 100 gram of sweet
     */
    protected int sugarConcentration;

    /**
     * Initialize base fields of sweets entity
     *
     * @param nameOfSweet name of sweet
     * @param manufacturer name of company that manufactures this sweet
     * @param weight sweet's weight in grams
     * @param sugarConcentration concentration of sugar in 100 grams of sweet
     */
    public Sweets(String nameOfSweet, String manufacturer, int weight, int sugarConcentration) {
        this.nameOfSweet = nameOfSweet;
        this.manufacturer = manufacturer;
        this.weight = weight;
        this.sugarConcentration = sugarConcentration;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSugarConcentration() {
        return sugarConcentration;
    }

    public void setSugarConcentration(int sugarConcentration) {
        this.sugarConcentration = sugarConcentration;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNameOfSweet() {
        return nameOfSweet;
    }

    public void setNameOfSweet(String nameOfSweet) {
        this.nameOfSweet = nameOfSweet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sweets)) return false;

        Sweets sweets = (Sweets) o;

        if (sugarConcentration != sweets.sugarConcentration) return false;
        if (weight != sweets.weight) return false;
        if (!manufacturer.equals(sweets.manufacturer)) return false;
        if (!nameOfSweet.equals(sweets.nameOfSweet)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weight;
        result = 31 * result + sugarConcentration;
        result = 31 * result + manufacturer.hashCode();
        result = 31 * result + nameOfSweet.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Sweets{" +
                "nameOfSweet='" + nameOfSweet + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", weight=" + weight +
                ", sugarConcentration=" + sugarConcentration +
                '}';
    }
}
