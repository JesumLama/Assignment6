import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {
    Order orderOne, orderTwo;

    @Before
    public void setUp() throws Exception {
        orderOne = new Order(1, Day.MONDAY, new Customer("Mary", 22));
        orderTwo = new Order(2, Day.SATURDAY, new Customer("John", 45));
    }

    @After
    public void tearDown() throws Exception {
        orderOne = orderTwo = null;
    }

    @Test
    public void testGetBeverage() {
        Coffee cf = new Coffee("regular Coffee", Size.SMALL, false, false);
        Alcohol al = new Alcohol("Mohito", Size.SMALL, false);
        Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM, 1, false);
        Smoothie sm2 = new Smoothie("Detox", Size.LARGE, 1, false);

        orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
        orderOne.addNewBeverage("Mohito", Size.SMALL);
        orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);

        assertTrue(orderOne.getBeverages().get(0).equals(cf));
        assertTrue(orderOne.getBeverages().get(1).equals(al));
        assertTrue(orderOne.getBeverages().get(2).equals(sm1));
        assertFalse(orderOne.getBeverages().get(2).equals(sm2));
    }

    @Test
    public void testAddNewBeverage() throws NullPointerException {
        assertTrue(orderOne.getBeverages().size() == 0);

        orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
        orderOne.addNewBeverage("Mohito", Size.SMALL);
        orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);

        assertTrue(orderOne.getBeverages().size() == 3);

        orderTwo.addNewBeverage("Detox", Size.MEDIUM, 4, true);
        orderTwo.addNewBeverage("Mohito", Size.SMALL);
        orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);

        assertTrue(orderTwo.getBeverages().size() == 3);
    }

    @Test
    public void testCalcOrderTotal() {
        orderOne.addNewBeverage("regular Coffee", Size.SMALL, false, false);
        orderOne.addNewBeverage("Mohito", Size.SMALL);
        orderOne.addNewBeverage("Detox", Size.MEDIUM, 1, false);

        assertEquals(7.5, orderOne.calcOrderTotal(), .01);

        orderTwo.addNewBeverage("regular Coffee", Size.MEDIUM, true, false);
        orderTwo.addNewBeverage("Mohito", Size.SMALL);
        orderTwo.addNewBeverage("Detox", Size.MEDIUM, 4, true);

        assertEquals(12.6, orderTwo.calcOrderTotal(), .01);
    }
}
