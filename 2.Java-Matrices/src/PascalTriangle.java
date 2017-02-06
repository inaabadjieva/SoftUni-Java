import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();

        long[][] pascal = new long[rows][];

        for (int row = 0; row < rows; row++) {
            pascal[row] = new long[row + 1];
        }

        for (int row = 0; row < rows; row++) {
            pascal[row][0] = 1;
            pascal[row][pascal[row].length - 1] = 1;
            if(pascal[row].length > 2){
                for (int col = 1; col < pascal[row].length - 1; col++) {
                    pascal[row][col] = pascal[row - 1][col] + pascal[row - 1][col - 1];
                }
            }
        }
        for (long[] ints : pascal) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
