import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {
    Coffee coffee;

    @Before
    public void setUp() throws Exception {
        coffee = new Coffee("Latte", Size.MEDIUM, true, false);
    }

    @After
    public void tearDown() throws Exception {
        coffee = null;
    }

    @Test
    public void testCalcPrice() {
        assertEquals(3.5, coffee.calcPrice(), .01);
    }

    @Test
    public void testEquals() {
        Coffee sameCoffee = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee differentCoffee = new Coffee("Espresso", Size.SMALL, true, false);

        assertTrue(coffee.equals(sameCoffee));
        assertFalse(coffee.equals(differentCoffee));
    }
}
