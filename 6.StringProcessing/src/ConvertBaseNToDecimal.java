import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConvertBaseNToDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        BigInteger baseN = new BigInteger(input[0]);
        char[] num = input[1].toCharArray();

        BigInteger result = new BigInteger("0");

        int power = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            result = result.add(new BigInteger(Character.toString(num[i])).multiply(baseN.pow(power)));
            power++;
        }

        System.out.println(result);
    }
}
