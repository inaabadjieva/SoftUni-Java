import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class CustomMinFunc {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<int[], Integer> extractMin = nums -> {
            int min = nums[0];
            for (Integer num : nums) {
                if (num < min)
                    min = num;
            }

            return min;
        };

        String[] numAsString = reader.readLine().split("\\s+");
        int[] nums = new int[numAsString.length];

        int index = 0;
        for (String str : numAsString) {
            nums[index++] = Integer.parseInt(str);
        }

        int min = extractMin.apply(nums);
        System.out.println(min);
    }
}
