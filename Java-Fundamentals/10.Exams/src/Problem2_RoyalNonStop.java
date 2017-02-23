import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem2_RoyalNonStop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimen = reader.readLine().split(" ");

        String[] prices = reader.readLine().split(" ");

        BigDecimal totalMoney = BigDecimal.ZERO;
        Integer totalCustomers = 0;

        String line = "";
        while(!"Royal Close".equals(line = reader.readLine())){
            String[] tokens = line.split(" ");
            int initialRow = Integer.parseInt(tokens[0]);
            int initialColumn = Integer.parseInt(tokens[1]);

            BigDecimal currentSum = BigDecimal.ZERO;

            if(initialRow >= initialColumn) {
                //LEFT
                for (Integer currentColumn = initialColumn; currentColumn >= 0; currentColumn--) {

                    BigDecimal rowValue = new BigDecimal(initialRow + 1);
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);
                    BigDecimal productPrice = new BigDecimal(prices[initialRow % 2]);

                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }

                //UP
                for (Integer currentRow = initialRow - 1; currentRow > 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal productPrice = new BigDecimal(prices[currentRow % 2]);

                    BigDecimal productSum = rowValue.multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }
            } else {
                for (Integer currentRow = initialRow; currentRow >= 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal colValue = new BigDecimal(initialColumn + 1);
                    BigDecimal productPrice = new BigDecimal(prices[currentRow % 2]);

                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }

                //LEFT
                for (Integer currentColumn = initialColumn - 1; currentColumn > 0; currentColumn--) {
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);
                    BigDecimal productPrice = new BigDecimal(prices[0]);

                    BigDecimal productSum = colValue.multiply(productPrice);

                    currentSum = currentSum.add(productSum);
                }
            }

            totalMoney = totalMoney.add(currentSum);
            totalCustomers++;
        }

        System.out.println(totalMoney.setScale(6, RoundingMode.HALF_EVEN));
        System.out.println(totalCustomers);
    }
}
