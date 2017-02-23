import java.util.*;

public class ActivityTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        TreeMap<Integer, TreeMap<String, Integer>> map = new TreeMap<>();

        for (int i = 0; i < lines; i++) {
            String[] params = scanner.nextLine().split(" ");
            String[] date = params[0].split("/");
            int month = Integer.parseInt(date[1]);
            String name = params[1];
            int distance = Integer.parseInt(params[2]);

            if (!map.containsKey(month)) {
                map.put(month, new TreeMap<>());
            }

            if (!map.get(month).containsKey(name)) {
                map.get(month).put(name, 0);
            }

            TreeMap<String, Integer> mapDistance = map.get(month);
            mapDistance.put(name, mapDistance.get(name) + distance);
            map.put(month, mapDistance);
        }

        for (Integer month : map.keySet()) {
            System.out.print(month + ": ");
            int count = map.get(month).size();

            for (Map.Entry<String, Integer> entry : map.get(month).entrySet())
            {
                if (count > 1) {
                    System.out.printf("%s(%d), ", entry.getKey(), entry.getValue());
                    count--;
                } else {
                    System.out.printf("%s(%d)", entry.getKey(), entry.getValue());
                }
            }
            System.out.println();
        }
    }
}
