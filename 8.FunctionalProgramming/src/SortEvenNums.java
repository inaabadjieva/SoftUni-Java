import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortEvenNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] numsStr = reader.readLine().split(", ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : numsStr) {
            numbers.add(Integer.parseInt(s));
        }
        StringBuilder sb = new StringBuilder();
        numbers.removeIf(n -> n % 2 != 0);
        for (Integer s : numbers) {
            sb.append(s);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);

        numbers.sort((a, b) -> a.compareTo(b));
        sb = new StringBuilder();
        for (Integer s : numbers) {
            sb.append(s);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
