import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceExtractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = reader.readLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][^!.?]*?\\b" + word + "\\b[^!.?]*?[.!?]");

        String line = reader.readLine();

        Matcher matcher = pattern.matcher(line);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
