import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LettersChangeNums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        double sum = 0;
        for (String str : input) {
            char char1 = str.charAt(0);
            char char2 = str.charAt(str.length() - 1);
            double num = Integer.parseInt(str.substring(1, str.length() - 1));


            if(Character.isUpperCase(char1)){
                num /= ((char1 - 'A') + 1);
            } else {
                num *= ((char1 - 'a') + 1);
            }

            if(Character.isUpperCase(char2)){
                num -= (char2 - 'A') + 1;
            } else {
                num += (char2 - 'a') + 1;
            }

            sum += num;
        }

        System.out.println(String.format("%.2f", sum));
    }
}
