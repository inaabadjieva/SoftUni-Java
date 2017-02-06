import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeriesOfLetters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("([a-zA-Z])\\1+");

        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            input = matcher.replaceAll("$1");
        }

        System.out.println(input);
    }
}
