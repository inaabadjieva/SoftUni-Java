import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class FindSmallestElem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        List<Integer> nums = new ArrayList<>();
        for (String s : input) {
            nums.add(Integer.parseInt(s));
        }

        Function<List<Integer>, Integer> getIndexOfSmallestElement = arr -> {
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;
            int index = 0;

            for (Integer num : arr) {
                if(num <= minValue){
                    minValue = num;
                    minIndex = index;
                }
                index++;
            }

            return minIndex;
        };

        Consumer<Integer> printResult = x -> System.out.println(x);

        printResult.accept(getIndexOfSmallestElement.apply(nums));
    }
}
