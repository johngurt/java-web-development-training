package training.gamelessormore;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {

    private static Model model;

    @Before
    public void setUp() {
        model = new Model(-20,20);
    }

    @After
    public void tearDown() {
        model = null;
    }

    @Test
    public void testPlayerWin() {
        model.setCurrentNumber(model.getUnknownNumber());
        Assert.assertTrue(model.playerWin());
    }

    @Test
    public void testUnknownNumberMoreThanCurrent() {
        model.setCurrentNumber(model.getUnknownNumber() + 1);
        Assert.assertFalse(model.unknownNumberMoreThanCurrent());
    }

    @Test
    public void testIsOutOfBoundary() {
        model.setCurrentNumber(1000);
        Assert.assertTrue(model.isOutOfBoundary(model.getCurrentNumber()));
    }

    @Test
    public void testIsOutOfBoundary1() {
        model.setCurrentNumber(18);
        Assert.assertFalse(model.isOutOfBoundary(model.getCurrentNumber()));
    }
}