import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Problem4_AshesOfRoses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<String, Long>> result = new HashMap<>();

        String line = "";
        while(!"Icarus, Ignite!".equals(line = reader.readLine())){
            if(!line.matches("Grow <[A-Z][a-z]+> <[A-Za-z0-9]+> [0-9]+")){
                continue;
            }
            String[] params = line.split("\\s+");
            String region = params[1].substring(1, params[1].length() - 1);
            String color = params[2].substring(1, params[2].length() - 1);
            long amount = Integer.parseInt(params[3].trim());

            if(!result.containsKey(region)){
                result.put(region, new HashMap<>());
            }

            if(!result.get(region).containsKey(color)){
                result.get(region).put(color, 0L);
            }

            result.get(region).put(color, result.get(region).get(color) + amount);
        }


        result.entrySet().stream()
                .sorted((r1, r2) -> {
            long sum1 = r1.getValue().values().stream().mapToLong(e -> e).sum();
            long sum2 = r2.getValue().values().stream().mapToLong(e -> e).sum();
            if(sum1 == sum2){
                return r1.getKey().compareTo(r2.getKey());
            }
            return Long.compare(sum2, sum1);
        })
                .forEach(r -> {
                    System.out.println(r.getKey());
                    r.getValue().entrySet().stream()
                        .sorted((c1, c2) -> {
                            if(Long.compare(c1.getValue(), c2.getValue()) == 0){
                                return c1.getKey().compareTo(c2.getKey());
                            }
                            return Long.compare(c1.getValue(), c2.getValue());
                    }).forEach(c ->{
                        System.out.println("*--" + c.getKey() + " | " + c.getValue());
                    });
                });
    }
}
