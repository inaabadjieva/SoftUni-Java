import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MapDistricts {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        int limit = Integer.parseInt(reader.readLine());

        HashMap<String, ArrayList<Integer>> cities = new HashMap<>();
        for (String token : tokens) {
            String[] params = token.split(":");
            String city = params[0];
            int population = Integer.parseInt(params[1]);
            if(!cities.containsKey(city)){
                cities.put(city, new ArrayList<>());
            }
            cities.get(city).add(population);
        }

        cities.entrySet().stream()
                .filter(x -> x.getValue().stream().mapToInt(Integer::valueOf).sum() > limit)
                .sorted((x1, x2) -> Integer.compare(
                        x2.getValue().stream().mapToInt(Integer::valueOf).sum(),
                        x1.getValue().stream().mapToInt(Integer::valueOf).sum()))
                .forEach(x -> {
                    System.out.print(x.getKey() + ": " );
                    x.getValue().stream().sorted((a, b) -> b.compareTo(a)).limit(5).forEach(val -> System.out.print(val + " "));
                    System.out.println();
                });

    }
}
