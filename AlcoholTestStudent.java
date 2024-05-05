import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {
    Alcohol alcohol1, alcohol2;

    @Before
    public void setUp() throws Exception {
        alcohol1 = new Alcohol("Beer", Size.SMALL, false);
        alcohol2 = new Alcohol("Wine", Size.MEDIUM, false);
    }

    @After
    public void tearDown() throws Exception {
        alcohol1 = alcohol2 = null;
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.0, alcohol1.calcPrice(), 0.01);
        assertEquals(3.5, alcohol2.calcPrice(), 0.01);
    }

    @Test
    public void testEquals() {
        Alcohol sameAlcohol1 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol sameAlcohol2 = new Alcohol("Wine", Size.MEDIUM, false);
        assertTrue(alcohol1.equals(sameAlcohol1));
        assertTrue(alcohol2.equals(sameAlcohol2));
        assertFalse(alcohol1.equals(alcohol2));
    }

    @Test
    public void testToString() {
        String expectedAlcohol1 = "Beverage{name='Beer', type=ALCOHOL, size=SMALL} Alcohol{weekend=false, price=3.0}";
        String expectedAlcohol2 = "Beverage{name='Wine', type=ALCOHOL, size=MEDIUM} Alcohol{weekend=false, price=3.5}";
        assertEquals(expectedAlcohol1, alcohol1.toString());
        assertEquals(expectedAlcohol2, alcohol2.toString());
    }
}
