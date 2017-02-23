import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1_JediMeditation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            all.append(line);
        }
        // JEDI MATCHERS
        Matcher master = Pattern.compile("m\\d+").matcher(all);
        Matcher knight = Pattern.compile("k\\d+").matcher(all);
        Matcher toshkoOrSlav = Pattern.compile("(t\\d+)|(s\\d+)").matcher(all);
        Matcher padawan = Pattern.compile("p\\d+").matcher(all);
        Matcher masterYoda = Pattern.compile("y\\d+").matcher(all);

        StringBuilder result = new StringBuilder();
        if (masterYoda.find()) {
            while (master.find()) {
                result.append(master.group()).append(" ");
            }
            while (knight.find()) {
                result.append(knight.group()).append(" ");
            }
            while (toshkoOrSlav.find()) {
                result.append(toshkoOrSlav.group()).append(" ");
            }
            while (padawan.find()) {
                result.append(padawan.group()).append(" ");
            }
        } else {
            while (toshkoOrSlav.find()) {
                result.append(toshkoOrSlav.group()).append(" ");
            }
            while (master.find()) {
                result.append(master.group()).append(" ");
            }
            while (knight.find()) {
                result.append(knight.group()).append(" ");
            }
            while (padawan.find()) {
                result.append(padawan.group()).append(" ");
            }
        }
        System.out.println(result);
    }
}
