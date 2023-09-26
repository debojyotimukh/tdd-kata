public class StringSum {

    public static String sum(String num1, String num2) {
        int a = 0;
        int b = 0;
        try {
            a = Integer.parseUnsignedInt(num1);
            b = Integer.parseUnsignedInt(num2);
        } catch (NumberFormatException e){
            System.out.println("Not a natural number, taking 0: " + e.getMessage());
        }
        return String.valueOf(a + b);
    }
}
