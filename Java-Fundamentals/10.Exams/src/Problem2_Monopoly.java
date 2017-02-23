import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2_Monopoly {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimen = reader.readLine().split(" ");
        int rows = Integer.parseInt(dimen[0]);
        int cols = Integer.parseInt(dimen[1]);

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            char[] line = reader.readLine().toCharArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col];
            }
        }

        int totalMoney = 50;
        int hotels = 0;
        int turns = 0;
        boolean goingRight = true;

        for (int row = 0; row < rows; row++) {
            if(goingRight){
                for (int col = 0; col < cols; col++) {
                    char cell = matrix[row][col];
                    switch(cell){
                        case 'H':
                            hotels++;
                            System.out.println(String.format("Bought a hotel for %s. Total hotels: %s.", totalMoney, hotels));
                            totalMoney = 0;
                            break;
                        case 'J':
                            System.out.println(String.format("Gone to jail at turn %s.", turns));
                            turns += 2;
                            totalMoney += (hotels * 10) * 2;
                            break;
                        case 'S':
                            int moneyToSpend = (row + 1) * (col + 1);
                            moneyToSpend = moneyToSpend > totalMoney ? totalMoney : moneyToSpend;
                            totalMoney -= moneyToSpend;
                            System.out.println(String.format("Spent %s money at the shop.", moneyToSpend));
                            break;
                    }

                    totalMoney += hotels * 10;
                    turns++;
                }
                goingRight = false;
            } else {
                for (int col = cols - 1; col >= 0 ; col--) {
                    char cell = matrix[row][col];
                    switch(cell){
                        case 'H':
                            hotels++;
                            System.out.println(String.format("Bought a hotel for %s. Total hotels: %s.", totalMoney, hotels));
                            totalMoney = 0;
                            break;
                        case 'J':
                            System.out.println(String.format("Gone to jail at turn %s.", turns));
                            turns += 2;
                            totalMoney += (hotels * 10) * 2;
                            break;
                        case 'S':
                            int moneyToSpend = (row + 1) * (col + 1);
                            moneyToSpend = moneyToSpend > totalMoney ? totalMoney : moneyToSpend;
                            totalMoney -= moneyToSpend;
                            System.out.println(String.format("Spent %s money at the shop.", moneyToSpend));
                            break;
                    }

                    totalMoney += hotels * 10;
                    turns++;
                }
                goingRight = true;
            }
        }

        System.out.printf("Turns %d\n", turns);
        System.out.printf("Money %d\n", totalMoney);
    }
}
