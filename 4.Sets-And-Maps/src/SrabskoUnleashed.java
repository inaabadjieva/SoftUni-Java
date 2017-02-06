import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SrabskoUnleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern regex = Pattern.compile("([a-zA-Z]+\\s){1,3}@([a-zA-Z]+\\s){1,3}\\d+\\s\\d+");

        LinkedHashMap<String, LinkedHashMap<String, Long>> result = new LinkedHashMap<>();

        String line = reader.readLine();
        while(!"End".equals(line)){
            if (!regex.matcher(line).matches()) {
                line = reader.readLine();
                continue;
            }

            String[] tokens = line.split(" ");
            String singer = line.substring(0, line.indexOf('@')).trim();
            long ticketPrice = Long.parseLong(tokens[tokens.length - 2]);
            long ticketCount = Long.parseLong(tokens[tokens.length - 1]);
            String venue = line.substring(line.indexOf('@') + 1, line.indexOf(Long.toString(ticketPrice))).trim();

            if(!result.containsKey(venue)){
                result.put(venue, new LinkedHashMap<>());
            }
            if(!result.get(venue).containsKey(singer)){
                result.get(venue).put(singer, 0L);
            }
            result.get(venue).put(singer, result.get(venue).get(singer) + (ticketCount * ticketPrice));

            line = reader.readLine();
        }

        for (String key : result.keySet()) {
            System.out.println(key);
            result.get(key).entrySet().stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(p -> {
                        System.out.printf("#  %s -> %d\n", p.getKey(), p.getValue());
                    });
        }
    }
}
