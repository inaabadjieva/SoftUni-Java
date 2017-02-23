import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder text = new StringBuilder();

        String line = reader.readLine();
        while(!"END".equals(line)){
            text.append(line).append("\r\n");
            line = reader.readLine();
        }

        Pattern pattern = Pattern.compile("<a\\s+(href=[^>]+)>([^<]+)<\\/a>");
        Matcher matcher = pattern.matcher(text);

        while(matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String replacement = "[URL " + matcher.group(1)+ "]" + matcher.group(2) + "[/URL]";
            text.replace(start, end, replacement);
            matcher = pattern.matcher(text);
        }

        System.out.println(text);

    }
}
