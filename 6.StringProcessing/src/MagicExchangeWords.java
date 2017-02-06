import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class MagicExchangeWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String first = input[0];
        String second = input[1];

        HashSet<Character> firstSet = new HashSet<>();
        HashSet<Character> secondSet = new HashSet<>();

        for (int i = 0; i < first.length(); i++) {
            firstSet.add(first.charAt(i));
        }

        for (int i = 0; i < second.length(); i++) {
            secondSet.add(second.charAt(i));
        }

        System.out.println(firstSet.size() == secondSet.size() ? "true" : "false" );
    }
}
