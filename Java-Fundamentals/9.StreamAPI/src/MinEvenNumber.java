import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;

public class MinEvenNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        OptionalDouble min = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(n -> !n.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(n -> n % 2 == 0)
                .min();

        if (min.isPresent()){
            System.out.printf("%.2f", min.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
