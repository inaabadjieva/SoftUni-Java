import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RubikMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimen = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimen[0]);
        int cols = Integer.parseInt(dimen[1]);
        int[][] matrix = new int[rows][cols];
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            int pos = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            int times = Integer.parseInt(tokens[2]);
            shuffleMatrix(matrix, pos, direction, times);
        }

        int counter = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == counter) {
                    System.out.println("No swap required");
                    counter++;
                    continue;
                }

                outerLoop:
                for (int k = 0; k < matrix.length; k++) {
                    for (int l = 0; l < matrix[k].length; l++) {
                        if (matrix[k][l] == counter) {
                            System.out.printf("Swap (%d, %d) with (%d, %d)\n", row, col, k, l);
                            int temp = matrix[row][col];
                            matrix[row][col] = matrix[k][l];
                            matrix[k][l] = temp;
                            break outerLoop;
                        }
                    }
                }

                counter++;
            }
        }
    }

    private static void shuffleMatrix(int[][] matrix, int pos, String direction, int moves) {

        if ("up".equals(direction)) {    // col
            for (int i = 0; i < moves % matrix.length; i++) {
                int firstElement = matrix[0][pos];
                for (int j = 0; j < matrix.length - 1; j++) {
                    matrix[j][pos] = matrix[j + 1][pos];
                }
                matrix[matrix.length - 1][pos] = firstElement;
            }
        } else if ("down".equals(direction)) {  // col
            for (int i = 0; i < moves % matrix.length; i++) {
                int lastElement = matrix[matrix.length - 1][pos];
                for (int j = matrix.length - 1; j >= 1; j--) {
                    matrix[j][pos] = matrix[j - 1][pos];
                }
                matrix[0][pos] = lastElement;
            }
        } else if("right".equals(direction)) {    // row
            for(int i = 0; i < moves % matrix[pos].length; i++) {
                int lastElement = matrix[pos][matrix[pos].length - 1];
                for (int j = matrix[pos].length - 1; j >= 1; j--) {
                    matrix[pos][j] = matrix[pos][j - 1];
                }
                matrix[pos][0] = lastElement;
            }
        } else if ("left".equals(direction)) {  // row
            for (int i = 0; i < moves % matrix[pos].length; i++) {
                int firstElement = matrix[pos][0];
                for (int j = 0; j < matrix[pos].length - 1; j++) {
                    matrix[pos][j] = matrix[pos][j + 1];
                }
                matrix[pos][matrix[pos].length - 1] = firstElement;
            }
        }
    }
}
