import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringSumTest {
    @Test
    public void testEmpty() {
        Assertions.assertEquals("0", StringSum.sum("", ""));
    }

    @Test
    public void testSumNaturalNumbers() {
        Assertions.assertEquals("5", StringSum.sum("3", "2"));
    }

    @Test
    public void testSumOfNegativeNumbers() {
        Assertions.assertEquals("5", StringSum.sum("5", "-2"));
    }

    @Test
    public void testSumOfNonNaturalNumbers() {
        Assertions.assertEquals("5", StringSum.sum("5", "2.2"));
    }

}
