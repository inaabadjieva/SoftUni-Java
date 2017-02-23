import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] stock = new int[n];
        for (int i = 0; i < n; i++) {
            stock[i] = Integer.parseInt(scanner.nextLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            int index = 0;
            span[i] = 1;
            while (!stack.isEmpty() && stock[stack.peek()] <= stock[i]) {
                index = stack.pop();
                span[i] = i - index + span[index];
            }
            stack.push(i);
        }
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
}
