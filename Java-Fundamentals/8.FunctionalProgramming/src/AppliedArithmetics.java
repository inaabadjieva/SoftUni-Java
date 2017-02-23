import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        String command = "";

        BiFunction<String, Integer, Integer> doMagic = (x, y) -> {
            switch (x) {
                case "add":
                    return y + 1;
                case "multiply":
                    return y * 2;
                case "subtract":
                    return y - 1;
                default:
                    return null;
            }
        };

        Consumer<int[]> printThem = x -> {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < x.length; i++) {
                sb.append(x[i]).append(" ");
            }
            System.out.println(sb.toString().trim());
        };

        while ((!"end".equals(command = reader.readLine()))) {
            if (!"print".equals(command)) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = doMagic.apply(command, nums[i]);
                }
            } else {
                printThem.accept(nums);
            }
        }
    }
}
