import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class AverageOfDouble {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> elements = Arrays.asList(reader.readLine().split(" "));

        OptionalDouble average = elements.stream()
                .filter(n -> !n.isEmpty())
                .mapToDouble(Double::valueOf)
                .average();

        if (average.isPresent()){
            System.out.printf("%.2f", average.getAsDouble());
        } else {
            System.out.println("No match");
        }
    }
}
