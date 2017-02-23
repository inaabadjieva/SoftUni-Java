import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] params = scanner.nextLine().split("\\s+");
        int numsToPush = Integer.parseInt(params[0]);
        int numsToPop = Integer.parseInt(params[1]);
        int num = Integer.parseInt(params[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numsToPush; i++) {
            stack.push(scanner.nextInt());
        }
        for (int i = 0; i < numsToPop; i++) {
            stack.pop();
        }

        int min = Integer.MAX_VALUE;
        for (Integer current : stack) {
            if(current < min){
                min = current;
            }
        }
        if(stack.contains(num)){
            System.out.println("true");
        } else if(stack.size() == 0) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}
