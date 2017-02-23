import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SumBigNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstNum = reader.readLine();
        String secondNum = reader.readLine();

        BigInteger result = new BigInteger(firstNum).add(new BigInteger(secondNum));
        System.out.println(result);

    }
}
