import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

    @Test
    public void testMinimumLength() {
        PasswordChecker.ValidationResult result = PasswordChecker.isValid("Abc#123");
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password must be at least 8 characters", result.getMessage());
    }

    @Test
    public void testAtLeastTwoNumbers() {
        PasswordChecker.ValidationResult result = PasswordChecker.isValid("Abcde#g1");
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password must contain at least 2 numbers", result.getMessage());
    }

    @Test
    public void testMultipleErrors() {
        PasswordChecker.ValidationResult result = PasswordChecker.isValid("Abcd#");
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password must be at least 8 characters\nPassword must contain at least 2 numbers", result.getMessage());
    }

    @Test
    public void testAtLeastOneCapital() {
        PasswordChecker.ValidationResult result = PasswordChecker.isValid("abcdef#12");
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password must contain at least one capital letter", result.getMessage());
    }

    @Test
    public void testAtLeastOneSpecialCharacter() {
        PasswordChecker.ValidationResult result = PasswordChecker.isValid("Abcdef12");
        Assertions.assertFalse(result.isValid());
        Assertions.assertEquals("Password must contain at least one special character", result.getMessage());
    }
}
