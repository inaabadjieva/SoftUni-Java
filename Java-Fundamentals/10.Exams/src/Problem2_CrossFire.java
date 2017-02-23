import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem2_CrossFire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        ArrayList<ArrayList<Integer>> matrix = fillMatrix(rows, cols);

        String line = reader.readLine();
        while(!"Nuke it from orbit".equals(line)){
            String[] params = line.split(" ");
            int shotRow = Integer.parseInt(params[0]);
            int shotCol = Integer.parseInt(params[1]);
            int shotRadius = Integer.parseInt(params[2]);

            for (int row = shotRow - shotRadius; row <= shotRow + shotRadius; row++) {
                if(isInMatrix(row, shotCol, matrix)){
                    matrix.get(row).set(shotCol, -1);
                }
            }

            for (int col = shotCol - shotRadius; col <= shotCol + shotRadius; col++) {
                if(isInMatrix(shotRow, col, matrix)){
                    matrix.get(shotRow).set(col, -1);
                }
            }

            filterMatrix(matrix);
            line = reader.readLine();
        }

        printMatrix(matrix);
    }

    private static void filterMatrix(ArrayList<ArrayList<Integer>> matrix){
        for (int row = 0; row < matrix.size(); row++) {
            matrix.get(row).removeAll(Arrays.asList((new Integer[] {-1})));
        }
        matrix.removeAll(Arrays.asList(new ArrayList<Integer>()));
    }

    private static ArrayList<ArrayList<Integer>> fillMatrix(Integer rows, Integer cols) {
        ArrayList<ArrayList<Integer>> numberMatrix = new ArrayList<>();
        int count = 1;

        for (int row = 0; row < rows; row++) {
            numberMatrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                numberMatrix.get(row).add(count);
                count++;
            }
        }

        return numberMatrix;
    }

    private static boolean isInMatrix(int currentRow, int currentCol, ArrayList<ArrayList<Integer>> numberMatrix){
        if(currentRow >= 0 && currentRow < numberMatrix.size() &&
                currentCol >= 0 && currentCol < numberMatrix.get(currentRow).size()){
            return true;
        }
        return false;
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            String currentLine = "";
            for (int col = 0; col < matrix.get(row).size(); col++) {
                currentLine += matrix.get(row).get(col) + " ";
            }

            System.out.println(currentLine.trim());
        }
    }
}
