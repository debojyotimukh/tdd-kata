import java.util.Arrays;

public class PasswordChecker {

    public static ValidationResult isValid(String password) {
        ValidationResult result = new ValidationResult();
        if (password.length() < 8) {
            result.append("Password must be at least 8 characters");
        }
        int numberOfDigits = 0;
        int capitalCount = 0;
        int specialCharCount = 0;
        for (Character ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                numberOfDigits++;
            }
            if (Character.isUpperCase(ch)) {
                capitalCount++;
            }
            if (Arrays.asList('$', '#', '&').contains(ch)) {
                specialCharCount++;
            }
        }
        if (numberOfDigits < 2) {
            result.append("Password must contain at least 2 numbers");
        }
        if (capitalCount < 1) {
            result.append("Password must contain at least one capital letter");
        }
        if (specialCharCount < 1) {
            result.append("Password must contain at least one special character");
        }
        return result;
    }

    public static class ValidationResult {
        private boolean isValid;

        private String errorMessage;

        ValidationResult() {
            this(true, "");
        }

        ValidationResult(boolean isValid, String errorMessage) {
            this.isValid = isValid;
            this.errorMessage = errorMessage;
        }

        void append(String msg) {
            this.isValid = false;
            this.errorMessage = "".equals(this.errorMessage) ? msg : this.errorMessage + "\n" + msg;
        }

        String getMessage() {
            return this.errorMessage;
        }

        boolean isValid() {
            return this.isValid;
        }
    }
}
