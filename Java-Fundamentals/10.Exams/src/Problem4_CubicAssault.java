import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Problem4_CubicAssault {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, TreeMap<String, Long>> result = new TreeMap<>();

        //fill in map
        String input = "";
        while(!"Count em all".equals(input = reader.readLine())){
            String[] tokens = input.split(" -> ");
            String region = tokens[0];
            String meteor = tokens[1];
            long count = Long.parseLong(tokens[2]);

            if(!result.containsKey(region)){
                result.put(region, new TreeMap<>());
                result.get(region).put("Black", 0L);
                result.get(region).put("Red", 0L);
                result.get(region).put("Green", 0L);
            }

            count += result.get(region).get(meteor);
            if (count >= 1000000) {
                if (meteor.equals("Green")) {
                    result.get(region).put("Green", 0L);
                    long redCount = count / 1000000 + result.get(region).get("Red");
                    count %= 1000000;
                    result.get(region).put("Red", redCount);
                    if (redCount >= 1000000) {
                        result.get(region).put("Red", 0L);
                        long blackCount = redCount / 1000000;
                        long oldBlackCount = result.get(region).get("Black");
                        result.get(region).put("Black", blackCount + oldBlackCount);
                        continue;
                    }
                } else if (meteor.equals("Red")) {
                    result.get(region).put("Red", 0L);
                    long blackCount = count / 1000000;
                    count %= 1000000;
                    long oldBlackCount = result.get(region).get("Black");
                    result.get(region).put("Black", blackCount + oldBlackCount);
                }
            }

            result.get(region).put(meteor, count);
        }

        //sorting
            result.entrySet().stream()
                    .sorted((m1, m2) -> Integer.compare(m1.getKey().length(), m2.getKey().length()))
                    .sorted((m1, m2) -> Long.compare(m2.getValue().get("Black"), m1.getValue().get("Black")))
                    .forEach(r -> {
                        System.out.println(r.getKey());
                        r.getValue().entrySet().stream()
                                .sorted((m1, m2) -> Long.compare(m2.getValue(), m1.getValue()))
                                .forEach(c -> System.out.println("-> " + c.getKey() + " : " + c.getValue()));
                    });

    }
}
