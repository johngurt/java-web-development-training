package training.initialize;

import training.model.*;

/**
 * This enum contains data for initializing
 *
 * @author Hurt Yevhenii
 */
public enum Initialization {
    A(new ChocolateCandies("Jack", "Konti", 50, 62, ChocolateType.BLACK)),
    B(new ChocolateCandies("Snackfood", "Mars", 88, 48, ChocolateType.MILK)),
    C(new ChocolateCandies("Truffles", "Lindor", 200, 55, ChocolateType.WHITE)),
    D(new Pastry("Croissant", "Kulinichi", 120, 11, TypeOfFlour.WHITE)),
    E(new Pastry("Strudel", "Wrights", 100, 25, TypeOfFlour.WHOLE_WHEAT)),
    F(new Pastry("Puff", "Baker Street", 125, 13, TypeOfFlour.WHITE_WITH_GERM));

    private Sweets sweets;

    Initialization(Sweets sweets) {
        this.sweets = sweets;
    }

    public Sweets getSweets() {
        return sweets;
    }
}
