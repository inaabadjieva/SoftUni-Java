import java.util.ArrayDeque;
import java.util.Scanner;

public class SequenceWithQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startNum = scanner.nextLong();

        ArrayDeque<Long> sequence = new ArrayDeque<>();
        sequence.add(startNum);

        for (int i = 0; i < 50; i++) {
            long num = sequence.remove();

            System.out.print(num + " ");

            sequence.add(num + 1);
            sequence.add(2 * num + 1);
            sequence.add(num + 2);
        }
    }
}
