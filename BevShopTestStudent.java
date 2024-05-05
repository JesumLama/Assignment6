import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {
    BevShop bevShop;

    @Before
    public void setUp() throws Exception {
        bevShop = new BevShop();
    }

    @After
    public void tearDown() throws Exception {
        bevShop = null;
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 30);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Bob", 25);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Charlie", 22);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "David", 18);
        bevShop.processSmoothieOrder("Tropical", Size.LARGE, 3, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(10, Day.MONDAY, "Eve", 30);
        bevShop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        bevShop.processSmoothieOrder("Tropical", Size.LARGE, 3, true);
        assertEquals(9.8, bevShop.totalMonthlySale(), .01);
    }
}
