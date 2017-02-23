import java.util.ArrayList;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }

        String line = scanner.nextLine();
        while(!line.equals("END")){
            String[] params = line.split(" ");

            if(!params[0].equals("swap") ||
                    params.length > 5 ||
                    params.length < 5){
                System.out.println("Invalid input!");
                line = scanner.nextLine();
                continue;
            }

            int row1 = Integer.parseInt(params[1]);
            int col1 = Integer.parseInt(params[2]);
            int row2 = Integer.parseInt(params[3]);
            int col2 = Integer.parseInt(params[4]);

            if(isInMatrix(row1, col1, rows, cols) &&
                    isInMatrix(row1, col1, rows, cols)){
                String temp = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = temp;
            } else {
                System.out.println("Invalid input!");
                line = scanner.nextLine();
                continue;
            }

            printMatrix(matrix);
            line = scanner.nextLine();
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(int row, int col, int rows, int cols) {
        if (row >= 0 && row < rows &&
                col >= 0 && col < cols) {
            return true;
        }

        return false;
    }
}
