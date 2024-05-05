import static org.junit.Assert.*;
import org.junit.Test;

public class TypeTestStudent {
    @Test
    public void testEnumValues() {
        assertEquals("COFFEE", Type.COFFEE.toString());
        assertEquals("SMOOTHIE", Type.SMOOTHIE.toString());
        assertEquals("ALCOHOL", Type.ALCOHOL.toString());
    }
}
