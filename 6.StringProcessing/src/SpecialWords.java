import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SpecialWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(" ");
        String[] text = reader.readLine().split(" ");

        HashMap<String, Integer> result = new HashMap<>();

        for (String word : words) {
            result.put(word, 0);
            for (String s : text) {
                if(word.equals(s)){
                    result.put(word, result.get(word) + 1);
                }
            }
        }

        for (String key : result.keySet()) {
            System.out.println(key + " - " + result.get(key));
        }
    }
}
