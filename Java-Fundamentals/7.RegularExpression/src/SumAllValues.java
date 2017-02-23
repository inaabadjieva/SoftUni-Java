import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SumAllValues {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String keys = reader.readLine();
        String text = reader.readLine();

        Pattern patternStart = Pattern.compile("^[a-zA-Z_]+(?=[0-9])");
        Matcher matcherStart = patternStart.matcher(keys);

        Pattern patternEnd = Pattern.compile("(?<=[0-9])[a-zA-Z_]+$");
        Matcher matcherEnd = patternEnd.matcher(keys);

        if (matcherStart.find() && matcherEnd.find()){
            Pattern pattern = Pattern.compile(matcherStart.group() + "((\\d+)?\\.?(\\d+)?)" + matcherEnd.group());
            Matcher matcher = pattern.matcher(text);
            double sum = 0.0;

            while (matcher.find()){
                sum += Double.parseDouble(matcher.group(1));
            }

            if(sum > 0){
                DecimalFormat df = new DecimalFormat("#.##");
                System.out.printf("<p>The total value is: <em>%s</em></p>\n", df.format(sum));
            } else {
                System.out.println("<p>The total value is: <em>nothing</em></p>");
            }
        } else {
            System.out.println("<p>A key is missing</p>");
        }
    }
}
