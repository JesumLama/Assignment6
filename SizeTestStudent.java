import static org.junit.Assert.*;
import org.junit.Test;

public class SizeTestStudent {
    @Test
    public void testEnumValues() {
        assertEquals("SMALL", Size.SMALL.toString());
        assertEquals("MEDIUM", Size.MEDIUM.toString());
        assertEquals("LARGE", Size.LARGE.toString());
    }
}
