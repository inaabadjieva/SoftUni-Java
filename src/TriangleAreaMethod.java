import java.util.Scanner;

public class TriangleAreaMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        double area = calculateArea(base, height);
        System.out.printf("Area = %.2f", area);
    }

    public static double calculateArea(double base, double height) {
        return (base * height) / 2;
    }
}
