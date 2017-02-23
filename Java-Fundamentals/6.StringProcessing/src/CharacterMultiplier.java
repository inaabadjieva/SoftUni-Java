import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String str1 = input[0];
        String str2 = input[1];
        int minLength = Math.min(str1.length(), str2.length());

        int sum = 0;
        for (int i = 0; i < minLength; i++) {
            sum += str1.charAt(i) * str2.charAt(i);
        }

        for (int i = minLength; i < str1.length(); i++) {
            sum += str1.charAt(i);
        }

        for (int i = minLength; i < str2.length(); i++) {
            sum += str2.charAt(i);
        }

        System.out.println(sum);
    }
}
