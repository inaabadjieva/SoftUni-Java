import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        String word3 = scanner.next();

        int sum = num1 + num2 + num3;

        System.out.printf("%s %s %s %d", word1, word2, word3, sum);

    }
}
