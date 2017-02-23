import java.util.HashMap;
import java.util.Scanner;

public class CountValuesInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        HashMap<String, Integer> result = new HashMap<>();

        for (String num : input) {
            if(!result.containsKey(num)){
                result.put(num, 0);
            }
            result.put(num, result.get(num) + 1);

        }

        for (String key : result.keySet()) {
            System.out.printf("%s - %s times\n", key, result.get(key));
        }
     }
}
