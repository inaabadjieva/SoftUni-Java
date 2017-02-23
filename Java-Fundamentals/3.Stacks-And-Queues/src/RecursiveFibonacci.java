import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt() + 1;

        Deque<Long> fibNums = getFibonacciQueue(n);

        System.out.println(fibNums.pop());
    }

    private static Deque<Long> getFibonacciQueue(int n) {
        if (n == 1) {
            Deque<Long> fibNums = new ArrayDeque<>();
            fibNums.push(Long.valueOf(1));
            return fibNums;
        } else {
            Deque<Long> fibNums = getFibonacciQueue(n - 1);
            Long number = fibNums.poll();
            Long previousNumber = fibNums.poll();
            if (previousNumber == null) {
                previousNumber = Long.valueOf(0);
            }
            Long nextNumber = number + previousNumber;
            fibNums.push(number);
            fibNums.push(nextNumber);

            return fibNums;
        }
    }
}
