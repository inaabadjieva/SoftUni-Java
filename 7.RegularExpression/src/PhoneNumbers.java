import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        StringBuilder input = new StringBuilder();

        String line = reader.readLine();
        while(!"END".equals(line)){
            input.append(line);
            line = reader.readLine();
        }

        Pattern pattern = Pattern.compile("([A-Z](?:[a-zA-Z]+)?)[^a-zA-Z+]*?([+]?[0-9]+[()\\/.\\- ]*[0-9]+(?:[()\\/" +
                ".\\- ]+[0-9]+)*)");
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()) {
            String number = matcher.group(2);
            number = number.replaceAll("[^+\\d]+", "");
            result.put(matcher.group(1), number);
        }

        if(result.isEmpty()){
            System.out.println("<p>No matches!</p>");
        } else {
            System.out.print("<ol>");
            for (String key : result.keySet()) {
                System.out.printf("<li><b>%s:</b> %s</li>", key, result.get(key));
            }
            System.out.println("</ol>");
        }
    }
}
