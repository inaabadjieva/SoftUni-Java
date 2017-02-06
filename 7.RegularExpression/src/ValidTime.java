import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidTime {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})\\s(AM|PM)$");
        String text = reader.readLine();

        while (!text.equals("END")) {
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                if (isValidTime(matcher)) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }
            } else {
                System.out.println("invalid");
            }

            text = reader.readLine();
        }
    }

    private static boolean isValidTime(Matcher matcher) {
        int hour = Integer.parseInt(matcher.group(1));
        int minutes = Integer.parseInt(matcher.group(2));
        int seconds = Integer.parseInt(matcher.group(3));

        if(!(hour >= 1 && hour <= 12)){
            return false;
        }
        if(!(minutes >= 0 && minutes <= 59)){
            return false;
        }
        if(!(seconds >= 0 && seconds <= 59)){
            return false;
        }

        return true;
    }
}
