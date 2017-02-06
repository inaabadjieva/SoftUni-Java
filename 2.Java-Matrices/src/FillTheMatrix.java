import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split(", ");
        int size = Integer.parseInt(params[0]);
        String type = params[1];

        int[][] matrix = new int[size][size];

        if(type.equals("A")){
            matrix = fillMatrixPatternA(matrix);
        } else {
            matrix = fillMatrixPatternB(matrix);
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] fillMatrixPatternA(int[][] matrix){
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[0].length; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
        return matrix;
    }

    public static int[][] fillMatrixPatternB(int[][] matrix){
        int num = 1;
        for (int col = 0; col < matrix.length; col++) {
            if(col % 2 == 0){
                for (int row = 0; row < matrix[0].length; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            } else {
                for (int row = matrix[0].length - 1; row >= 0; row--) {
                    matrix[row][col] = num;
                    num++;
                }
            }
        }
        return matrix;
    }
}
