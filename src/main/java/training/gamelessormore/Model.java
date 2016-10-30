package training.gamelessormore;

/**
 * Created by gurt on 10/30/16.
 */
public class Model {

    private final int MIN_RAND;
    private final int MAX_RAND;

    Model() {
        MIN_RAND = 0;
        MAX_RAND = 100;
    }

    Model(int MIN_RAND, int MAX_RAND) {
        this.MIN_RAND = MIN_RAND;
        this.MAX_RAND = MAX_RAND;
    }


}
