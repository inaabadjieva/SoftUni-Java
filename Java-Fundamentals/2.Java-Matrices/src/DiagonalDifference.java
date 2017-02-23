import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        int diagonalLeft = 0;
        int diagonalRight = 0;

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            diagonalLeft += matrix[row][row];
            diagonalRight += matrix[matrix.length - row - 1][row];
        }

        System.out.println(Math.abs(diagonalLeft - diagonalRight));
    }
}
