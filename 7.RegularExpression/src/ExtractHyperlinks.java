import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractHyperlinks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String command = reader.readLine();
        while (!"END".equals(command)) {
            builder.append(command);
            command = reader.readLine();
        }

        String str = "<a\\s+(?:[^>]+\\s+)?href\\s*=\\s*('([^']*)'|\\\"([^\\\"]*)|([^\\\\s>]+))[^>]*>";
        Pattern pattern = Pattern.compile(str);
        Matcher m = pattern.matcher(builder);
        while (m.find()) {
            for (int i = 4; i > 0; i--) {
                if (m.group(i) != null) {
                    System.out.println(m.group(i));
                    break;
                }
            }
        }
    }
}