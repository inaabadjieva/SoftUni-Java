import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] text = scanner.nextLine().toCharArray();

        TreeMap<Character, Integer> result = new TreeMap<>();

        for (Character ch: text) {
            if(!result.containsKey(ch)){
                result.put(ch, 0);
            }

            result.put(ch, result.get(ch) + 1);
        }

        for (Character ch : result.keySet()) {
            System.out.printf("%s: %d time/s\n", ch, result.get(ch));
        }
    }
}
