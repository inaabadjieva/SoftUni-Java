import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class TakeTwo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> nums = Arrays.asList(reader.readLine().split(" "));
        nums.stream()
                .map(Integer::parseInt)
                .filter(n -> 10 <= n && n <= 20)
                .distinct()
                .limit(2)
                .forEach(n -> System.out.print(n + " "));
    }
}
