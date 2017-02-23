import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem3_RageQuit {
    private static Set<Character> counter = new LinkedHashSet<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(input);

        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(input);

        int readyIndex = 0;

        while (matcher.find()) {
            String digit = matcher.group(1);
            int index = input.indexOf(digit, readyIndex);
            String reminder = sb.substring(readyIndex, index);
            reminder = reminder.toUpperCase();

            for (char character : reminder.toCharArray()) {
                counter.add(character);
            }
            for (int i = 0; i < Integer.parseInt(digit); i++) {
                result.append(reminder);
            }

            if (digit.length() == 1) {
                readyIndex = index + 1;
            } else {
                readyIndex = index + 2;
            }
        }

        result.append(sb.substring(readyIndex).toUpperCase());

        List<Character> chars = result.toString().chars().mapToObj(e->(char)e).collect(Collectors.toList());

        long count = chars.stream().distinct().count();
        System.out.println("Unique symbols used: " + count);
        System.out.println(result);
    }
}
