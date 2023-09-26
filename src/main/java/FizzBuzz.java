import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static String generate(int range) {
        if (range <= 0)
            return "";

        IntFunction<String> fizzBuzzMapper = (value) -> {
            if(value % 3 == 0 && value % 5 == 0)
                return "FizzBuzz";
            if(value % 3 == 0)
                return "Fizz";
            if(value % 5 == 0)
                return "Buzz";
            else return String.valueOf(value);
        };

        return IntStream.rangeClosed(1, range).mapToObj(fizzBuzzMapper).collect(Collectors.joining(","));
    }
}
