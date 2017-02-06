import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Integer> userDuration = new HashMap<>();
        TreeMap<String, TreeMap<String, Integer>> result = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String ip = line[0];
            String username = line[1];
            int duration = Integer.parseInt(line[2]);

            if(!result.containsKey(username)){
                result.put(username, new TreeMap<>());
                userDuration.put(username, duration);
            } else {
                userDuration.put(username, userDuration.get(username) + duration);
            }

            result.get(username).put(ip, duration);
        }

        for (String key : result.keySet()) {
            System.out.printf("%s: %d [", key, userDuration.get(key));
            int count = result.get(key).size();
            for (String s : result.get(key).keySet()) {
                if(count > 1){
                    System.out.printf("%s, ", s);
                } else {
                    System.out.printf("%s", s);
                }
                count--;
            }
            System.out.print("]\n");
        }

    }
}
