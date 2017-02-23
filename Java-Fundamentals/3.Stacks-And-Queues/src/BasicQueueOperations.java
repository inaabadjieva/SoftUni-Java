import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void mascanner(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split("\\s+");
        int numsToAdd = Integer.parseInt(params[0]);
        int numsToRemove = Integer.parseInt(params[1]);
        int num = Integer.parseInt(params[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numsToAdd; i++) {
            int elementToAdd = scanner.nextInt();
            queue.add(elementToAdd);
        }
        for (int i = 0; i < numsToRemove; i++) {
            queue.remove();
        }

        int min = Integer.MAX_VALUE;
        for (Integer current : queue) {
            if(current < min){
                min = current;
            }
        }
        if(queue.size() == 0){
            System.out.println(0);
        } else if(queue.contains(num)){
            System.out.println(true);
        } else {
            System.out.println(min);
        }
    }
}


