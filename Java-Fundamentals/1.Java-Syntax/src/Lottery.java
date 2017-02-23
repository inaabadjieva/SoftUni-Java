
public class Lottery {
    public static void main(String[] args) {
        for (int num1 = 1; num1 <= 8; num1++) {
            for (int num2 = num1 + 1; num2 <= 9; num2++) {
                for (int num3 = num2 + 1; num3 <= 10; num3++) {
                    System.out.printf("%d %d %d\n", num1, num2, num3);
                }
            }
        }
    }
}
