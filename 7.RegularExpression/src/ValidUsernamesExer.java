import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernamesExer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] usernames = reader.readLine().split("[\\s\\\\\\/()]");

        String regex = "[a-zA-Z][\\w+]{2,25}";
        Pattern pattern = Pattern.compile(regex);

        List<String> result = new ArrayList<>();
        for (String username : usernames) {
            //Matcher matcher = pattern.matcher(username);
            if (Pattern.matches(regex, username.trim())) {
                result.add(username);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < result.size() - 1; i++) {
            int sum = 0;
            sum += result.get(i).length() + result.get(i + 1).length();
            if(sum > maxSum){
                maxSum = sum;
                maxIndex = i;
            }
        }

        System.out.println(result.get(maxIndex));
        System.out.println(result.get(maxIndex + 1));
    }
}
