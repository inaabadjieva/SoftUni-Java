import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem4_Olympics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        //Set<String> players;
        LinkedHashMap<String, HashMap<String, Integer>> countries = new LinkedHashMap<>();
        //LinkedHashMap<String, Integer> wins = new LinkedHashMap<>();

        String line = "";
        while (!"report".equals(line = reader.readLine())) {
            input = line.split("\\|");
            String name = input[0].trim().replaceAll("\\s+", " ");
            String country = input[1].trim().replaceAll("\\s+", " ");

            if (!countries.containsKey(country)) {
                countries.put(country, new HashMap<>());
            }
            if (!countries.get(country).containsKey(name)) {
                countries.get(country).put(name, 0);
            }
            countries.get(country).put(name, countries.get(country).get(name) + 1);
        }

        countries.entrySet().stream()
                .sorted((c1, c2) -> {
                    int wins1 = c1.getValue().values().stream().mapToInt(e -> e).sum();
                    int wins2 = c2.getValue().values().stream().mapToInt(e -> e).sum();
                    return Integer.compare(wins2, wins1);
                })
                .forEach(c -> {
                    System.out.printf("%s (%d participants): %d wins\n", c.getKey(), c.getValue().size(), c.getValue().values().stream().mapToInt(e -> e).sum());
                });
    }
}
