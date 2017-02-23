import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class OfficeStuff {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        TreeMap<String, LinkedHashMap<String, Integer>> result = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" - ");
            String company = line[0].substring(1);
            int amount = Integer.parseInt(line[1]);
            String product = line[2].substring(0, line[2].length() - 1);

            if(!result.containsKey(company)){
                result.put(company, new LinkedHashMap<>());
            }

            if(!result.get(company).containsKey(product)){
                result.get(company).put(product, 0);
            }

            result.get(company).put(product, result.get(company).get(product) + amount);
        }

        for (String company : result.keySet()) {
            System.out.print(company + ": ");
            int index = 0;
            for (String product : result.get(company).keySet()) {
                if(index >= result.get(company).size() - 1){
                    System.out.print(product + "-" + result.get(company).get(product));
                } else {
                    System.out.print(product + "-" + result.get(company).get(product) + ", ");
                }
                index++;
            }
            System.out.println();
        }
    }
}
