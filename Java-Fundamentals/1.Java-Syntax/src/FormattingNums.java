import java.util.Scanner;

public class FormattingNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        System.out.printf("|%s|%s|%10.2f|%-10.3f|", String.format("%-10X", a), String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0"), b, c);
    }
}
