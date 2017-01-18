import java.util.Scanner;

public class BlurFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int blur = Integer.parseInt(scanner.nextLine());
        String[] coord = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(coord[0]);
        int cols = Integer.parseInt(coord[1]);

        //read the matrix
        long[][] matrix = new long[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] coordToBlur = scanner.nextLine().split(" ");
        int row = Integer.parseInt(coordToBlur[0]);
        int col = Integer.parseInt(coordToBlur[1]);

        int rowUp = row - 1;
        int rowDown = row + 1;
        if (rowUp < 0){
            rowUp = 0;
        }
        if (rowDown > rows - 1){
            rowDown = rows - 1;
        }
        int colLeft = col - 1;
        int colRight = col + 1;
        if (colLeft < 0) {
            colLeft = 0;
        }
        if (colRight > cols-1) {
            colRight = cols-1;
        }

        for (int i = rowUp; i <= rowDown; i++)
        {
            for (int j = colLeft; j <= colRight; j++)
            {
                matrix[i][j] = matrix[i][j] + blur;
            }
        }

        //print
        for (long[] a : matrix) {
            for (long i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
