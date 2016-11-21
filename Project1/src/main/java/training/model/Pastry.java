package training.model;

/**
 * Entity of pastry
 *
 * @author Hurt Yevhenii
 */
public class Pastry extends Sweets {

    /**
     * Type of flour that used for making pastry
     */
    private TypeOfFlour typeOfFlour;

    /**
     * Initialize base fields of Pastry and it's parent Sweets
     *
     * @param nameOfSweet name of sweet
     * @param manufacturer name of company that manufactures this sweet
     * @param weight sweet's weight in grams
     * @param sugarConcentration concentration of sugar in 100 grams of sweet
     * @param typeOfFlour type of flour which used for making pastry
     */
    public Pastry(String nameOfSweet, String manufacturer, int weight, int sugarConcentration, TypeOfFlour typeOfFlour) {
        super(nameOfSweet, manufacturer, weight, sugarConcentration);
        this.typeOfFlour = typeOfFlour;
    }

    public TypeOfFlour getTypeOfFlour() {
        return typeOfFlour;
    }

    public void setTypeOfFlour(TypeOfFlour typeOfFlour) {
        this.typeOfFlour = typeOfFlour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pastry)) return false;
        if (!super.equals(o)) return false;

        Pastry pastry = (Pastry) o;

        return typeOfFlour == pastry.typeOfFlour;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + typeOfFlour.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pastry{" +
                super.toString() +
                ", typeOfFlour=" + typeOfFlour +
                '}';
    }
}


