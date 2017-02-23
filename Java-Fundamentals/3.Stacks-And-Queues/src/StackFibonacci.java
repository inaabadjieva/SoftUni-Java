import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        Deque<Long> fibNums = new ArrayDeque<>();

        for (int i = 0; i < n + 1; i++) {
            if(fibNums.size() < 2){
                fibNums.push(Long.valueOf(1));
            } else {
                long num = fibNums.pop();
                long prev = fibNums.peek();
                fibNums.push(num);
                fibNums.push(num + prev);
            }
        }
        System.out.println(fibNums.pop());
    }
}
