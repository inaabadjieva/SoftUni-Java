import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class CountUppercase {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] textAsList = reader.readLine().split(" ");
        Predicate<String> checkerUpperCase = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        int count = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < textAsList.length; i++) {
            if (checkerUpperCase.test(textAsList[i])) {
                result.add(textAsList[i]);
                count++;
            }
        }
        System.out.println(count);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
