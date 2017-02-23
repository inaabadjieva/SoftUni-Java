import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        List<Integer> nums = new ArrayList<>();
        for (String s : input) {
            nums.add(Integer.parseInt(s));
        }

        int divisor = Integer.parseInt(reader.readLine());

        Function<List<Integer>, List<Integer>> reverse = x -> {
            List<Integer> reversed = new ArrayList<>();
            for (int i = x.size() - 1; i >= 0; i--) {
                reversed.add(x.get(i));
            }

            return reversed;
        };

        List<Integer> reversed = reverse.apply(nums);
        reversed.removeIf(x -> x % divisor == 0);

        for (Integer integer : reversed) {
            System.out.print(integer + " ");
        }
    }
}
