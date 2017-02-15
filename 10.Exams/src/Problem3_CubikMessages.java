import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_CubikMessages {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String str = reader.readLine();
        while(true){
            if("Over!".equals(str)){
                break;
            }
            int length = Integer.parseInt(reader.readLine());
            Pattern pattern = Pattern.compile("^([0-9]+)([a-zA-Z]{" + length + "})([^a-zA-Z]*)$");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String message = matcher.group(2);
                result.append(message);
                result.append(" == ");
                for (Character s : matcher.group().toCharArray()) {
                    if(Character.isDigit(s)){
                        int index = Integer.parseInt(s.toString());
                        if(index >= 0 && index < message.length()){
                            result.append(message.charAt(index));
                        } else {
                            result.append(" ");
                        }
                    }
                }
                System.out.println(result);
                result = new StringBuilder();
            }

            str = reader.readLine();
        }
    }
}
