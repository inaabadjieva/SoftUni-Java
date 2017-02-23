import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;

public class PredicateNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");

        BiPredicate<String, Integer> isNameShorter = (n, l) -> n.length() <= l;

        for (String name : names) {
            if (isNameShorter.test(name, length)) {
                System.out.println(name);
            }
        }
    }
}
