import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2_BunkerBuster {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimen = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimen[0]);
        int cols = Integer.parseInt(dimen[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] line = reader.readLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(line[col]);
            }
        }
        String input = "";
        while(!"cease fire!".equals(input = reader.readLine())){
            String[] tokens = input.split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int damage = String.valueOf(tokens[2]).codePointAt(0);

            bombMatrix(matrix, row, col, damage);
        }

        int cellsDestroyed = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col] <= 0){
                    cellsDestroyed ++;
                }
            }
        }

        System.out.printf("Destroyed bunkers: %d\n", cellsDestroyed);
        Double percent = (double)(cellsDestroyed * 100.0f) / (matrix.length * matrix[0].length);
        System.out.println("Damage done: " + String.format("%.1f", percent) + " %");
    }

    private static void bombMatrix(int[][] matrix, int inpactRow, int inpactCol, int damage) {
        int halfDamage = damage % 2 == 0 ? damage / 2 : (damage / 2) + 1;
        for (int row = inpactRow - 1; row <= inpactRow + 1; row++) {
            for (int col = inpactCol - 1; col <= inpactCol + 1; col++) {
                if (isInMatrix(row, col, matrix)) {
                    if (row == inpactRow && col == inpactCol) {
                        matrix[row][col] -= damage;
                    } else {
                        matrix[row][col] -= halfDamage;
                    }
                }
            }
        }
    }

    private static boolean isInMatrix(int currentRow, int currentCol, int[][] matrix){
        if(currentRow >= 0 && currentRow < matrix.length &&
                currentCol >= 0 && currentCol < matrix[0].length){
            return true;
        }
        return false;
    }

}
