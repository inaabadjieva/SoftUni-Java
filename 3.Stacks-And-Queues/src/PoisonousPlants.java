import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Integer> plants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plants.add(scanner.nextInt());
        }

        int[] days = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 0; i < plants.size(); i++) {
            int maxDays = 0;
            while (stack.size() > 0 &&
                    plants.get(stack.peek()) >= plants.get(i)) {
                maxDays = Math.max(maxDays, days[stack.pop()]);
            }

            if (stack.size() > 0) {
                days[i] = maxDays + 1;
            }
            stack.push(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > max)
                max = days[i];
        }
        System.out.println(max);
    }
}
