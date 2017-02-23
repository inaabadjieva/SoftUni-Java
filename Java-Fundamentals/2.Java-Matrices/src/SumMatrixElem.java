import java.util.Scanner;

public class SumMatrixElem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(params[0]);
        int cols = Integer.parseInt(params[1]);
        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
                sum += Integer.parseInt(line[j]);
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
