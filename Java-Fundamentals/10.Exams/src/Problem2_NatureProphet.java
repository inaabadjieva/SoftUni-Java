import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2_NatureProphet {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimen = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(dimen[0]);
        int cols = Integer.parseInt(dimen[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        List<Integer> coord = new ArrayList<>();

        String line = reader.readLine();
        while(!"Bloom Bloom Plow".equals(line)){
            String[] params = line.split("\\s+");
            int currentRow = Integer.parseInt(params[0]);
            int currentCol = Integer.parseInt(params[1]);

            matrix[currentRow][currentCol] = 1;
            coord.add(currentRow);
            coord.add(currentCol);
            line = reader.readLine();
        }

        for (int i = 0; i < coord.size(); i+=2) {
            fillInMatrix(matrix, coord.get(i), coord.get(i+1));
//            fillInRow(matrix, coord.get(i), coord.get(i+1));
//            fillInCol(matrix, coord.get(i), coord.get(i+1));
        }

        printMatrix(matrix);
    }

    private static void fillInMatrix(int[][] matrix, Integer row, Integer col) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i != row && j == col){
                    matrix[i][j] += 1;
                }
                if(i == row && j != col){
                    matrix[row][j] += 1;
                }
            }
        }
    }

    private static void fillInCol(int[][] matrix, int row, int col) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i != row && j == col){
                    matrix[i][j] += 1;
                }
            }
        }
    }

    private static void fillInRow(int[][] matrix, int row, int col) {
        for (int j = 0; j < matrix[0].length; j++) {
            if(j != col){
                matrix[row][j] += 1;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[1].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
