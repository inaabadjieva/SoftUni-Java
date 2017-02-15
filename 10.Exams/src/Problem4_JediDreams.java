import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4_JediDreams {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, ArrayList<String>> methods = new TreeMap<>();
        Pattern patternStaticMethod = Pattern.compile("(?<=static)\\s+[a-zA-Z]+\\s+([a-zA-Z]+)\\s*\\(");
        Pattern patternMethod = Pattern.compile("[.\\s]([A-Z]+[a-zA-Z]+?)\\s*\\(");
        String method = "";
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            Matcher matcherStaticMethod = patternStaticMethod.matcher(line);
            if(matcherStaticMethod.find()){
                method = matcherStaticMethod.group(1);
                methods.put(method, new ArrayList<>());
                continue;
            }

            Matcher matcherMethod = patternMethod.matcher(line);
            while(matcherMethod.find()){
                methods.get(method).add(matcherMethod.group(1));
            }
        }

        //sort and print
        methods.entrySet().stream()
                .sorted((m1, m2) -> Integer.compare(m2.getValue().size(), m1.getValue().size()))
                .forEach(m -> {
                    StringBuilder result = new StringBuilder();
                    result.append(m.getKey());
                    if(m.getValue().size() > 0){
                        result.append(" -> ").append(m.getValue().size()).append(" -> ");
                    } else {
                        result.append(" -> None");
                    }

                    m.getValue().stream()
                            .sorted((m1, m2) -> m1.compareTo(m2))
                            .forEach(x -> result.append(x).append(", "));

                    if(m.getValue().size() > 0){
                        System.out.println(result.substring(0, result.length() - 2));
                    } else {
                        System.out.println(result);
                    }

                });
    }
}
