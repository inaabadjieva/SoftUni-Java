import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> result = new ArrayDeque<>();
        for (String num : nums) {
            result.push(Integer.parseInt(num));
        }

        while(result.size() > 0){
            System.out.print(result.pop() + " ");
        }
    }
}
