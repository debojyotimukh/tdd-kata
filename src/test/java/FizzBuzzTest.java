import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    @Test
    public void testNegativeRange() {
        Assertions.assertEquals("", FizzBuzz.generate(-1));
    }

    @Test
    public void testRangeZero() {
        Assertions.assertEquals("", FizzBuzz.generate(0));
    }

    @Test
    public void testRangeOne() {
        Assertions.assertEquals("1", FizzBuzz.generate(1));
    }

    @Test
    public void testRangeTwo() {
        Assertions.assertEquals("1,2", FizzBuzz.generate(2));
    }

    @Test
    public void testFizz() {
        Assertions.assertEquals("1,2,Fizz", FizzBuzz.generate(3));
    }

    @Test
    public void testBuzz() {
        Assertions.assertEquals("1,2,Fizz,4,Buzz", FizzBuzz.generate(5));
    }

    @Test
    public void testFizzBuzz() {
        String expected = "1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz";
        Assertions.assertEquals(expected, FizzBuzz.generate(15));
    }

}
