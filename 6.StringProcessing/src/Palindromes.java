import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> result = new TreeSet<>();

        String[] input = reader.readLine().split("[\\p{Punct}\\s]+");

        for (String word : input) {
            if(word.equals(new StringBuilder(word).reverse().toString())){
                result.add(word);
            }
        }

        System.out.println(result);
    }
}
