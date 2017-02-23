import java.util.ArrayDeque;
import java.util.Scanner;

public class MaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();

            if (command == 1) {
                int numToPush = scanner.nextInt();
                stack.push(numToPush);
                if (max < numToPush) {
                    max = numToPush;
                    maxStack.push(max);
                }
            } else if (command == 2) {
                int poppedItem = stack.pop();
                if (poppedItem == max) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        max = maxStack.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(max);
            }
        }
    }
}
