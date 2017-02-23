import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertDecimalToBaseN {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        BigInteger baseN = new BigInteger(input[0]);
        BigInteger num = new BigInteger(input[1]);

        StringBuilder result = new StringBuilder();
        while (num.compareTo(new BigInteger("0")) != 0) {
            result.append(num.remainder(baseN));
            num = num.divide(baseN);
        }

        System.out.println(result.reverse());
    }
}
