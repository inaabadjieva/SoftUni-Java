import java.util.Scanner;

public class DecimalToBase7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.printf("%s", Integer.toString(num, 7));
    }
}
