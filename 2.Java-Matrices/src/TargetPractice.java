import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TargetPractice {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        String text = reader.readLine();
        String[] shotParameters = reader.readLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int impactRow = Integer.parseInt(shotParameters[0]);
        int impactCol = Integer.parseInt(shotParameters[1]);
        int radius = Integer.parseInt(shotParameters[2]);

        char[][] matrix = new char[rows][cols];

        fillMatrix(rows, cols, text, matrix);

        explode(rows, cols, impactRow, impactCol, radius, matrix);

        for (int i = 0; i < cols; i++) {
            for (int j = rows - 2; j >= 0; j--) {
                if (matrix[j][i] != ' ') {
                    for (int k = j; k < rows - 1; k++) {
                        if (matrix[k + 1][i] == ' ') {
                            matrix[k + 1][i] = matrix[k][i];
                            matrix[k][i] = ' ';
                        } else {
                            break;
                        }
                    }
                }
            }
        }

//        for (int row = matrix.length - 1; row >= 0; row--) {
//            for (int column = 0; column < matrix[0].length; column++) {
//                if (matrix[row][column] != ' ') {
//                    continue;
//                }
//
//                int currentRow = row - 1;
//                while (currentRow >= 0) {
//                    if (matrix[currentRow][column] != ' ') {
//                        matrix[row][column] = matrix[currentRow][column];
//                        matrix[currentRow][column] = ' ';
//                        break;
//                    }
//
//                    currentRow--;
//                }
//            }
//        }

        printMatrix(matrix);
    }

    private static void fillMatrix(int rows, int cols, String text, char[][] matrix) {
        boolean toTheLeft = true;
        int index = 0;
        for (int i = rows - 1; i >= 0; i--) {
            if (toTheLeft) {
                for (int j = cols - 1; j >= 0; j--) {
                    matrix[i][j] = text.charAt(index);

                    index++;
                    if (index == text.length())
                        index = 0;
                }

                toTheLeft = false;
            } else {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = text.charAt(index);

                    index++;
                    if (index == text.length())
                        index = 0;
                }

                toTheLeft = true;
            }
        }
    }

    private static void explode(int rows, int cols, int impactRow, int impactCol, int radius, char[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (Math.pow((i - impactRow), 2) + Math.pow((j - impactCol), 2) <= Math.pow(radius, 2)) {
                    matrix[i][j] = ' ';
                }
            }
        }
    }

    static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }

            System.out.println();
        }
    }
}
