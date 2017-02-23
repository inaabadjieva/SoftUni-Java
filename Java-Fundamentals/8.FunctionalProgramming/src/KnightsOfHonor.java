import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> print = x -> System.out.println("Sir " + x);

        String[] names = reader.readLine().split(" ");

        for (String name : names) {
            print.accept(name);
        }
    }
}
