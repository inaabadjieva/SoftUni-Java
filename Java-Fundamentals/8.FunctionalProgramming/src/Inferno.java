import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Predicate;

public class Inferno {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        HashMap<String, Predicate<Integer>> predicatesForExclude = new HashMap<>();

        while (true) {
            String[] command = reader.readLine().split(";");
            if ("Forge".equals(command[0])){
                break;
            }
            Predicate<Integer> condition = makePredicate (command[1], Integer.valueOf(command[2]), arr);
            switch (command[0]) {
                case "Exclude":
                    predicatesForExclude.put(command[1] + command[2], condition);
                    break;
                case "Reverse":
                    predicatesForExclude.remove(command[1] + command[2]);
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for(Predicate<Integer> predicate : predicatesForExclude.values()){
                if(predicate.test(i)){
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static Predicate<Integer> makePredicate(String condition, Integer value, int[] arr) {
        switch (condition){
            case "Sum Left":
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] == value;
            case "Sum Right":
                return index -> (index < arr.length - 1 ? arr[index + 1] : 0) + arr[index] == value;
            default:
                return index -> (index > 0 ? arr[index - 1] : 0) + arr[index] +
                        (index < arr.length-1 ? arr[index + 1] : 0) == value;
        }
    }
}
