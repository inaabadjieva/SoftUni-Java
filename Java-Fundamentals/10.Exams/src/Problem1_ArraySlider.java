import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem1_ArraySlider {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        input = input.replaceAll("\\s+", " ").trim();
        String[] arr = input.split("\\s+");
        List<BigInteger> result = new ArrayList<>();
        for (String s : arr) {
            result.add(new BigInteger(s));
        }

        int currentIndex = 0;

        String line = "";
        while (!"stop".equals(line = reader.readLine().trim())) {
            String[] tokens = line.split("\\s+");
            int offset = Integer.parseInt(tokens[0]);
            String operation = tokens[1];
            BigInteger operand = new BigInteger(tokens[2]);

            currentIndex = findIndex(result, currentIndex, offset);

            BigInteger value = result.get(currentIndex);
            result.remove(currentIndex);

            switch (operation) {
                case "+":
                    result.add(currentIndex, valueChecker(value.add(operand)));
                    break;
                case "-":
                    result.add(currentIndex, valueChecker(value.subtract(operand)));
                    break;
                case "*":
                    result.add(currentIndex, valueChecker(value.multiply(operand)));
                    break;
                case "/":
                    result.add(currentIndex, valueChecker(value.divide(operand)));
                    break;
                case "&":
                    result.add(currentIndex, valueChecker(value.and(operand)));
                    break;
                case "|":
                    result.add(currentIndex, valueChecker(value.or(operand)));
                    break;
                case "^":
                    result.add(currentIndex, valueChecker(value.xor(operand)));
                    break;
            }
        }

        System.out.println(result);
    }

    private static int findIndex(List<BigInteger> result, int currentIndex, int offset) {
        offset = offset % result.size();
        if (result.size() == 1) {
            currentIndex = 0;
        } else {
            if (currentIndex + offset > result.size() - 1) {
                currentIndex = (currentIndex + offset) % (result.size());
            } else if (currentIndex + offset < 0) {
                currentIndex = result.size() + (currentIndex + offset);
            } else {
                currentIndex = currentIndex + offset;
            }
        }
        return currentIndex;
    }

    private static BigInteger valueChecker(BigInteger input) {
        if (input.compareTo(BigInteger.ZERO) < 0) {
            return BigInteger.ZERO;
        }
        return input;
    }
}
