import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1_Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimen = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(dimen[0]);
        int cols = Integer.parseInt(dimen[1]);

        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = 0;
            }
        }

        String line = "";
        while(!"Here We Go".equals(line = reader.readLine())){
            String[] params = line.split("\\s+");
            int startRow = Integer.parseInt(params[0]);
            int startCol = Integer.parseInt(params[1]);
            int endRow = Integer.parseInt(params[2]);
            int endCol = Integer.parseInt(params[3]);

            for (int row = startRow; row <= endRow; row++) {
                for (int col = startCol; col <= endCol; col++) {
                    matrix[row][col]++;
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
