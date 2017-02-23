import java.util.Arrays;
import java.util.Scanner;

public class ReadPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLine();
        }
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
