import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTestStudent {
    Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("John", 25);
    }

    @After
    public void tearDown() throws Exception {
        customer = null;
    }

    @Test
    public void testCopyConstructor() {
        Customer copy = new Customer(customer);
        assertEquals(customer.getName(), copy.getName());
        assertEquals(customer.getAge(), copy.getAge());
    }

    @Test
    public void testToString() {
        assertEquals("Customer{name='John', age=25}", customer.toString());
    }
}
