import java.util.Scanner;

public class SquaresInMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(params[0]);
        int cols = Integer.parseInt(params[1]);
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }

        int count = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if(matrix[row][col] == matrix[row][col + 1] &&                          matrix[row][col] == matrix[row + 1][col] &&                       matrix[row][col] == matrix[row + 1][col + 1]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
