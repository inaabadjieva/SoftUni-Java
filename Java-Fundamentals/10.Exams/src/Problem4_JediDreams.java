import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem4_JediDreams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, List<String>> methods = new TreeMap<>();
        Pattern pattern = Pattern.compile("([a-zA-Z]*[A-Z]+[A-Za-z]*)\\s*\\(");
        String method = "";
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Matcher matcher = pattern.matcher(line);

            if (line.trim().startsWith("static")) {
                if(matcher.find()) {
                    method = matcher.group(1);
                    methods.put(method, new ArrayList<>());
                }
            }
            while (matcher.find()) {
                methods.get(method).add(matcher.group(1));
            }
        }

        //sort and print
        methods.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue().size(), a.getValue().size()))
                .forEach(m -> {
                    if (m.getValue().isEmpty()) {
                        System.out.printf("%s -> None%n", m.getKey());
                    } else {
                        System.out.printf("%s -> %d -> %s%n",
                            m.getKey(),
                            m.getValue().size(),
                            String.join(", ", m.getValue()
                                .stream()
                                .sorted(String::compareTo)
                                .collect(Collectors.toList())));
                    }

        });
    }
}
