import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryMess {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("[^&?]+=[^&?]+");

        String line = reader.readLine();
        while(!"END".equals(line)){
            LinkedHashMap<String, ArrayList<String>> result = new LinkedHashMap<>();

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){
                String[] tokens = matcher.group().split("=");
                String key = tokens[0].replaceAll("%20|\\+"," ").trim();
                String value = tokens[1].replaceAll("%20|\\+"," ").replaceAll("\\s+", " ").trim();

                if(result.containsKey(key)){
                    result.get(key).add(value);
                } else {
                    ArrayList<String> val = new ArrayList<>();
                    val.add(value);
                    result.put(key,val);
                }
            }

            for (String key : result.keySet()) {
                System.out.print(key + "=" + result.get(key));
            }
            System.out.println();
            line = reader.readLine();
        }
    }
}
