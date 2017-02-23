import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_JediCode {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < n; i++) {
            input.append(reader.readLine());
        }

        String namePattern = reader.readLine();
        String nameRegex = String.format("%s([a-zA-Z]{%d}(?!([a-zA-Z])))", namePattern, namePattern.length());
        Pattern namePat = Pattern.compile(nameRegex);
        Matcher nameMatcher = namePat.matcher(input.toString());

        String messagePattern = reader.readLine();
        String messageRegex = String.format("%s(?<message>[a-zA-Z0-9]{%d}(?![a-zA-Z0-9]))", messagePattern, messagePattern.length());
        Pattern messagePat = Pattern.compile(messageRegex);
        Matcher messageMatcher = messagePat.matcher(input.toString());

        List<String> names = new ArrayList<>();
        List<String> messages = new ArrayList<>();

        while (nameMatcher.find()) {
            names.add(nameMatcher.group(1));
        }

        while (messageMatcher.find()) {
            messages.add(messageMatcher.group(1));
        }

        ArrayList<Integer> indexes = new ArrayList<>();
        String[] arr = reader.readLine().split(" ");
        for (String s : arr) {
            indexes.add(Integer.parseInt(s));
        }

        int currentIndex = 0;
        for (int i = 0; i < indexes.size(); i++) {
            if (indexes.get(i) - 1 < messages.size() && currentIndex < names.size()) {
                System.out.printf("%s - %s%n", names.get(currentIndex), messages.get(indexes.get(i) - 1));
                currentIndex++;
            }
        }
    }
}
