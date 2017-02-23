import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_MarkUpLanguage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern inverseReversePattern = Pattern.compile("\\<\\s*([\\w]+)\\s+content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\>");
        Pattern repeatPattern = Pattern.compile("\\<\\s*[\\w]+\\s+value\\s*\\=\\s*\"([0-9]+)\"\\s*content\\s*\\=\\s*\"(.+)\\s*\"\\s*\\/\\s*\\>");

        StringBuilder output = new StringBuilder();

        int count = 1;

        String input = "";
        while(!"<stop/>".equals(input = reader.readLine().trim())){
            Matcher inverseReverseMatcher = inverseReversePattern.matcher(input);
            Matcher repeatMatcher = repeatPattern.matcher(input);

            if(inverseReverseMatcher.find()){
                String command = inverseReverseMatcher.group(1).trim();
                String content = inverseReverseMatcher.group(2);
                String result = "";

                if(command.equals("inverse")){
                    for (int i = 0; i < content.length(); i++) {
                        int charValue = (int)content.charAt(i);
                        if(charValue >= 65 && charValue <= 90){
                            charValue += 32;
                        } else if(charValue >= 97 && charValue <= 122){
                            charValue -= 32;
                        }

                        result += (char)charValue;
                    }
                } else if(command.equals("reverse")){
                    for (int i = content.length() - 1; i >= 0; i--) {
                        result += content.charAt(i);
                    }
                }

                output.append(String.format("%s. %s\n", count, result));
                count++;
            } else if(repeatMatcher.find()){
                int value = Integer.parseInt(repeatMatcher.group(1).trim());
                String content = repeatMatcher.group(2);

                if(value != 0){
                    for (int i = 0; i < value; i++) {
                        output.append(String.format("%s. %s\n", count, content));
                        count++;
                    }
                }
            }
        }

        System.out.println(output);
    }
}
