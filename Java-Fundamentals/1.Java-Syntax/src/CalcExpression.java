import java.util.Scanner;

public class CalcExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double result1 = Math.pow((a*a + b*b)/(a*a - b*b), (a+b+c)/Math.sqrt(c)) ;
        double result2 = Math.pow(a*a + b*b - c*c*c, a-b);
        double result3 = Math.abs((a+b+c)/3 - (result1+result2)/2);

        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", result1, result2, result3);

    }
}
