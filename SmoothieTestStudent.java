import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SmoothieTestStudent {
    Smoothie smoothie;

    @Before
    public void setUp() throws Exception {
        smoothie = new Smoothie("Berry Blast", Size.SMALL, 3, true);
    }

    @After
    public void tearDown() throws Exception {
        smoothie = null;
    }

    @Test
    public void testCalcPrice() {
        assertEquals(5.0, smoothie.calcPrice(), .01);
    }

    @Test
    public void testEquals() {
        Smoothie sameSmoothie = new Smoothie("Berry Blast", Size.SMALL, 3, true);
        Smoothie differentSmoothie = new Smoothie("Tropical Delight", Size.LARGE, 2, false);

        assertTrue(smoothie.equals(sameSmoothie));
        assertFalse(smoothie.equals(differentSmoothie));
    }
}
