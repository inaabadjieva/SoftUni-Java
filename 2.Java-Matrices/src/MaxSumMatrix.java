import java.util.Scanner;

public class MaxSumMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(params[0]);
        int cols = Integer.parseInt(params[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sum = matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if(sum > maxSum){
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println(matrix[startRow][startCol] + " " + matrix[startRow][startCol + 1]);
        System.out.println(matrix[startRow + 1][startCol] + " " + matrix[startRow + 1][startCol + 1]);
        System.out.println(maxSum);
    }
}
