import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("[_,]([a-zA-Z]+)([\\d])");
        LinkedHashMap<String, String> all = new LinkedHashMap<>();

        while (true) {
            String input = reader.readLine();
            if ("Ascend".equals(input)) {
                break;
            }
            for (String s : all.keySet()) {
                input = input.replaceAll(s, all.get(s));
            }
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()){
                String match = matcher.group();
                String word = matcher.group(1);
                int number = Integer.valueOf(matcher.group(2));

                StringBuilder newWord = new StringBuilder();

                if (matcher.group(0).charAt(0) == '_'){
                    for (int i = 0; i < word.length(); i++) {
                        newWord.append((char) (word.charAt(i) - number));
                    }
                } else {
                    for (int i = 0; i < word.length(); i++) {
                        newWord.append((char) (word.charAt(i) + number));
                    }
                }

                input = input.replaceAll(match, newWord.toString());
                all.put(match, newWord.toString());
            }
            System.out.println(input);
        }
    }
}
