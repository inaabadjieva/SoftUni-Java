import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParseTags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();

        String startStr = "<upcase>";
        String endStr = "</upcase>";
        while(text.contains(startStr)){
            int startIndex = text.indexOf(startStr);
            int endIndex = text.indexOf(endStr);

            String reminder = text.substring(startIndex + 8, endIndex);
            String upReminder = reminder.toUpperCase();
            text = text.replaceFirst(reminder, upReminder);
            text = text.replaceFirst(startStr, "");
            text = text.replaceFirst(endStr, "");
        }
        System.out.println(text);

    }
}
