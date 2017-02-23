import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_TextTransformer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder();

        String line = "";
        while (!"burp".equals(line = reader.readLine())) {
            input.append(line.trim().replaceAll("\\s+", " "));
        }

        Pattern pattern = Pattern.compile("([$%&'])([^$%&']+)(\\1)");
        Matcher matcher = pattern.matcher(input);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            String symbol = matcher.group(1);
            String match = matcher.group(2);
            result.append(decodeString(symbol, match));
            result.append(" ");
        }

        System.out.println(result);
    }

    private static String decodeString(String symbol, String match) {
        char[] word = match.toCharArray();
        StringBuilder result = new StringBuilder();
        int number = getNumber(symbol);

        for (int i = 0; i < word.length; i++) {
            if (i % 2 == 0) {
                char rem = word[i];
                rem += number;
                result.append(rem);
            } else {
                char rem = word[i];
                rem -= number;
                result.append(rem);
            }
        }

        return result.toString();
    }

    private static int getNumber(String symbol) {
        switch (symbol) {
            case "$":
                return 1;
            case "%":
                return 2;
            case "&":
                return 3;
            case "'":
                return 4;
            default:
                return 0;
        }
    }
}
