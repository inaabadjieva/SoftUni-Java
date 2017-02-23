import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4_GUnit {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, HashMap<String, List<String>>> classes = new HashMap<>();

        Pattern pattern = Pattern.compile("^([A-Z]{1}[A-Za-z0-9]{2,}) \\| ([A-Z]{1}[A-Za-z0-9]{2,}) \\| " +
                "([A-Z]{1}[A-Za-z0-9]{2,})$");

        String input = "";
        while(!"It's testing time!".equals(input = reader.readLine())){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String className = matcher.group(1);
                String method = matcher.group(2);
                String test = matcher.group(3);
                if(!classes.containsKey(className)){
                    classes.put(className, new HashMap<>());
                }

                if(!classes.get(className).containsKey(method)){
                    classes.get(className).put(method, new ArrayList<>());
                }
                if(!classes.get(className).get(method).contains(test)){
                    classes.get(className).get(method).add(test);
                }
            }
        }

        //sort and print
        classes.entrySet().stream()
                .sorted((c1, c2) -> {
                    int size1 = findSize(c1.getValue().values());
                    int size2 = findSize(c2.getValue().values());
                    int result = Integer.compare(size2, size1);

                    if(result == 0){
                        result = Integer.compare(c1.getValue().keySet().size(), c2.getValue().keySet().size());
                    }
                    if(result == 0){
                        result = c1.getKey().compareTo(c2.getKey());
                    }
                    return result;
                })
                .forEach(r -> {
//                    System.out.println(findSize(r.getValue().values()));
                    System.out.printf("%s:\n", r.getKey());
                    r.getValue().entrySet().stream()
                            .sorted((m1, m2) -> {
                                int result = Integer.compare(m2.getValue().size(), m1.getValue().size());
                                if(result == 0){
                                    result = m1.getKey().compareTo(m2.getKey());
                                }
                                return result;
                            })
                            .forEach(m -> {
                                System.out.printf("##%s\n", m.getKey());
                                m.getValue().stream()
                                        .sorted((t1, t2) -> {
                                            int result = Integer.compare(t1.length(), t2.length());
                                            if(result == 0){
                                                result = t1.compareTo(t2);
                                            }
                                            return result;
                                        })
                                        .forEach(t -> System.out.printf("####%s\n", t));
                            });
                });
    }

    private static int findSize(Collection<List<String>> values) {
        int size = 0;
        for (List<String> value : values) {
            size += value.size();
        }
        return size;
    }
}
