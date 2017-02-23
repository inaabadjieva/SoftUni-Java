import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LegoBlocks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[][] matrix1 = new String[n][];
        String[][] matrix2 = new String[n][];

        int firstMatrixCells = 0;
        int secondMatrixCells = 0;

        //fill matrix1
        for (int i = 0; i < n; i++) {
            String[] elem = reader.readLine().trim().split("\\s+");
            matrix1[i] = new String[elem.length];
            firstMatrixCells += elem.length;
            for (int j = 0; j < elem.length; j++) {
                matrix1[i][j] = elem[j];
            }
        }

        //fill matrix2
        for (int i = 0; i < n; i++) {
            String[] elem = reader.readLine().trim().split("\\s+");
            matrix2[i] = new String[elem.length];
            secondMatrixCells += elem.length;
            for (int j = 0; j < elem.length; j++) {
                matrix2[i][j] = elem[j];
            }
        }

        int numberOfElements = matrix1[0].length + matrix2[0].length;

        //if not matching
        for (int i = 1; i < n; i++) {
            int currentNumberOfElements = matrix1[i].length + matrix2[i].length;
            if (currentNumberOfElements != numberOfElements) {
                System.out.println("The total number of cells is: " + (firstMatrixCells + secondMatrixCells));
                return;
            }
        }

        //combine both
        String[][] combinedMatrix =  new String[n][numberOfElements];
        for (int i = 0; i < n; i++) {
            int index = 0;

            for (int j = 0; j < matrix1[i].length; j++) {
                combinedMatrix[i][index] = matrix1[i][j];
                index++;
            }

            for (int j = matrix2[i].length - 1; j >= 0; j--) {
                combinedMatrix[i][index] = matrix2[i][j];
                index++;
            }
        }

        //printing
        for (int i = 0; i < n; i++) {
            System.out.print("[");
            boolean isFirst = true;

            for (int j = 0; j < numberOfElements; j++) {
                if (!combinedMatrix[i][j].equals(" ")) {
                    if (isFirst) {
                        System.out.print(combinedMatrix[i][j]);
                        isFirst = false;
                    } else {
                        System.out.print(", " + combinedMatrix[i][j]);
                    }
                }
            }

            System.out.println("]");
        }
    }
}
