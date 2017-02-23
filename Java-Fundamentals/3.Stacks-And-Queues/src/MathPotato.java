import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int times = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while(queue.size() > 1){
            for (int i = 1; i < times; i++) {
                String skipped = queue.poll();
                queue.offer(skipped);
            }
            if(isPrime(cycle)){
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    public static boolean isPrime(int num){
        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0){
                prime = false;
                break;
            }
        }
        return prime && num > 1;
    }
}
