import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ThePartyReservation {

    private static Predicate<String> currentPredicate;
    private static List<String> filter = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        while (true) {
            String[] command = reader.readLine().split(";");
            String action = command[0];
            if ("Print".equals(action)){
                break;
            }
            Predicate<String> lengthPredicate = (string) -> string.length() == Integer.parseInt(command[2]);
            Predicate<String> startsWithPredicate = (string) -> string.startsWith(command[2]);
            Predicate<String> endsWithPredicate = (string) -> string.endsWith(command[2]);
            Predicate<String> containsPredicate = (string) -> string.contains(command[2]);
            switch (command[1]) {
                case "Length":
                    currentPredicate = lengthPredicate;
                    break;
                case "Starts with":
                    currentPredicate = startsWithPredicate;
                    break;
                case "Ends with":
                    currentPredicate = endsWithPredicate;
                    break;
                case "Contains":
                    currentPredicate = containsPredicate;
                    break;
            }
            switch (command[0]) {
                case "Remove filter":
                    filter.removeIf(currentPredicate);
                    break;
                case "Add filter":
                    addFilter(list);
                    break;
            }
        }
        list.removeAll(filter);
        System.out.println(Arrays.toString(list.toArray()).replace("]", "").replace("[", "").replace(",",""));
    }

    private static void addFilter(List<String> list) {
        List<String> result = new ArrayList<>();
        for (String s1 : list) {
            if (currentPredicate.test(s1)) {
                result.add(s1);
            }
        }
        filter.addAll(result);
    }
}
