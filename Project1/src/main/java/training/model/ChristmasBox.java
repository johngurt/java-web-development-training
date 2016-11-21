package training.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Entity of Christmas present
 *
 * @author Hurt Yevhenii
 */
public class ChristmasBox {

    /**
     * Name of the human who will receive this present
     */
    private String nameOfReceiver;
    /**
     * List that contains all sweets that Christmas present contains
     */
    private List<Sweets> contentOfBox;

    /**
     * Constructor of Christmas box without content
     *
     * @param nameOfReceiver present receiver's name
     */
    public ChristmasBox(String nameOfReceiver) {
        this.nameOfReceiver = nameOfReceiver;
        contentOfBox = new ArrayList<Sweets>();
    }

    /**
     * Constructor of Christmas box with some content
     *
     * @param nameOfReceiver present receiver's name
     * @param contentOfBox list of sweets that present contains
     */
    public ChristmasBox(String nameOfReceiver, List<Sweets> contentOfBox) {
        this.nameOfReceiver = nameOfReceiver;
        this.contentOfBox = contentOfBox;
    }

    /**
     * Method that adds sweet to Christmas box
     *
     * @param sweet this sweet will be added to Christmas box
     */
    public void addSweet(Sweets sweet) {
        contentOfBox.add(sweet);
    }

    /**
     * This method computes net weight of Christmas box
     *
     * @return net weight of Christmas box
     */
    public int getTotalWeight() {

        return getContentOfBox().
                stream().
                map(Sweets::getWeight).
                reduce(0, (x, y) -> x + y);
    }

    /**
     * This method sorts content of Christmas box by one of the parameters
     *
     * @param sortBy one of values by which content of Christmas box will be sorted
     */
    public void sortChristmasBox(SortBy sortBy) {
        Collections.sort(contentOfBox, sortBy.getComparator());
    }

    /**
     * This method returns sweets from contents of Christmas box that satisfies constraints specified by predicate
     *
     * @param predicate constraints by which objects found
     * @return list of sweets that satisfies predicate
     */
    public List<Sweets> findSweetsInInterval(Predicate<Sweets> predicate) {
        return contentOfBox.stream().filter(predicate).collect(Collectors.toList());
    }

    public String getNameOfReceiver() {
        return nameOfReceiver;
    }

    public void setNameOfReceiver(String nameOfReceiver) {
        this.nameOfReceiver = nameOfReceiver;
    }

    public List<Sweets> getContentOfBox() {
        return contentOfBox;
    }

    public void setContentOfBox(List<Sweets> contentOfBox) {
        this.contentOfBox = contentOfBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChristmasBox)) return false;

        ChristmasBox that = (ChristmasBox) o;

        if (contentOfBox != null ? !contentOfBox.equals(that.contentOfBox) : that.contentOfBox != null) return false;
        if (nameOfReceiver != null ? !nameOfReceiver.equals(that.nameOfReceiver) : that.nameOfReceiver != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nameOfReceiver != null ? nameOfReceiver.hashCode() : 0;
        result = 31 * result + (contentOfBox != null ? contentOfBox.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChristmasBox{\n" +
                "nameOfReceiver='" + nameOfReceiver + '\'' +
                ",\ncontentOfBox=\n" + printContentOfBox(contentOfBox) +
                "weight = " + getTotalWeight() + " grams" +
                '}';
    }

    public String printContentOfBox(List<Sweets> contentOfBox) {
        StringBuilder stringBuilder = new StringBuilder("\t{\n");
        contentOfBox.forEach(
                content -> stringBuilder.append("\t\t")
                        .append(content)
                        .append("\n"));
        stringBuilder.append("\t}\n");
        return stringBuilder.toString();
    }
}
