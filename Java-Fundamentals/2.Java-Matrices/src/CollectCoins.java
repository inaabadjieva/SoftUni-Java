import java.util.Scanner;

public class CollectCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[4][];

        //fill the matrix
        for (int i = 0; i < matrix.length; i++) {
            char[] line = scanner.nextLine().toCharArray();
            matrix[i] = new char[line.length];
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j];
            }
        }

        char[] moves = scanner.nextLine().toCharArray();
        int currentRow = 0;
        int currentCol = 0;

        int coins = 0;
        int hits = 0;

        if (matrix[currentRow][currentCol] == '$')
            coins++;

        for (int i = 0; i < moves.length; i++) {
            int copyRow = currentRow;
            int copyCol = currentCol;

            switch (moves[i]) {
                case '^':
                    currentRow--;
                    break;
                case '>':
                    currentCol++;
                    break;
                case 'V':
                    currentRow++;
                    break;
                case '<':
                    currentCol--;
                    break;
            }

            if (!isInMatrix(currentRow, currentCol, matrix)) {
                currentRow = copyRow;
                currentCol = copyCol;
                hits++;
            } else {
                if (matrix[currentRow][currentCol] == '$')
                    coins++;
            }
        }

        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + hits);
    }

    private static boolean isInMatrix(int currentRow, int currentCol, char[][] matrix) {
        if (currentRow >= 0 &&
                currentCol >= 0 &&
                currentRow < matrix.length &&
                currentCol < matrix[currentRow].length) {
            return true;
        }

        return false;
    }
}
