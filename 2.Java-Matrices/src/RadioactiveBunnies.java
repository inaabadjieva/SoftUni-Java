import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RadioactiveBunnies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[rows][cols];
        int playerRow = 0;
        int playerCol = 0;

        //get player's coordinates
        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().toCharArray();
            ArrayList<Character> chars = new ArrayList<>();
            for (char c : matrix[i]) {
                chars.add(c);
            }
            if (chars.contains('P')) {
                playerRow = i;
                playerCol = chars.indexOf('P');
                matrix[playerRow][playerCol] = '.';
            }
        }

        String[] directions = reader.readLine().split("");
        for (String direction : directions) {
            int oldPlayerRow = playerRow;
            int oldPlayerCol = playerCol;
            switch (direction) {
                case "U": playerRow--; break;
                case "D": playerRow++; break;
                case "L": playerCol--; break;
                case "R": playerCol++; break;
            }

            matrix = spreadBunnies(matrix, rows - 1, cols - 1);

            if (playerRow < 0 || playerRow >= rows ||
                    playerCol < 0 || playerCol >= cols) {
                PrintResult(matrix, oldPlayerRow, oldPlayerCol, "won");
                return;
            }

            if (matrix[playerRow][playerCol] == 'B') {
                PrintResult(matrix, playerRow, playerCol, "dead");
                return;
            }
        }
    }

    private static char[][] spreadBunnies(char[][] matrix, int rows, int cols) {
        char[][] copyMatrix = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            copyMatrix[i] = matrix[i].clone();
        }

        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                if (matrix[row][col] == 'B') {
                    if (row > 0) copyMatrix[row - 1][col] = 'B';
                    if (row < rows) copyMatrix[row + 1][col] = 'B';
                    if (col > 0) copyMatrix[row][col - 1] = 'B';
                    if (col < cols) copyMatrix[row][col + 1] = 'B';
                }
            }
        }

        return copyMatrix;
    }

    private static void PrintResult(char[][] matrix, int row, int col, String outcome) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
        System.out.printf("%s: %d %d", outcome, row, col);
    }
}
