import java.math.BigInteger;
import java.util.Scanner;

public class ProductNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int number = n;
        BigInteger product = BigInteger.ONE;

        do {
            product = product.multiply(new BigInteger(String.valueOf(number)));
            number++;
        }
        while (number <= m);

        System.out.printf("product[%d..%d] = %d\n", n, m, product);
    }
}
