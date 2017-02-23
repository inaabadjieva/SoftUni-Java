import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2_JediGalaxy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimen = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimen[0]);
        int cols = Integer.parseInt(dimen[1]);

        long[][] matrix = new long[rows][cols];
        long count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = count;
                count++;
            }
        }

        long sum = 0;

        String input = reader.readLine();
        while(!"Let the Force be with you".equals(input)){
            String[] paramsIvo = input.split(" ");
            int rowIvo = Integer.parseInt(paramsIvo[0]);
            int colIvo = Integer.parseInt(paramsIvo[1]);

            String[] paramsEvil = reader.readLine().split(" ");
            int rowEvil = Integer.parseInt(paramsEvil[0]);
            int colEvil = Integer.parseInt(paramsEvil[1]);

            //delete
            while (rowEvil >= 0 && colEvil >= 0) {
                if (IsInMatrix(matrix, rowEvil, colEvil)) {
                    matrix[rowEvil][colEvil] = 0;
                }
                rowEvil--;
                colEvil--;
            }
            //sum
            while (rowIvo >= 0 && colIvo < cols) {
                if (IsInMatrix(matrix, rowIvo, colIvo)) {
                    sum += matrix[rowIvo][colIvo];
                }
                rowIvo--;
                colIvo++;
            }

            input = reader.readLine();
        }

        System.out.println(sum);
    }

    private static boolean IsInMatrix(long[][] matrix, int row, int col) {
        if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length){
            return true;
        }

        return false;
    }
}
