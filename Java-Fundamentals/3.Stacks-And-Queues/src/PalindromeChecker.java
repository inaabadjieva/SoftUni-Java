import java.util.ArrayDeque;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palindrome = scanner.nextLine();

        ArrayDeque<Character> queue = new ArrayDeque<>();

        for (Character character : palindrome.toCharArray()) {
            queue.offer(character);
        }

        boolean isPalindrome = true;
        while(queue.size() > 1){
            char first = queue.poll();
            char last = queue.pollLast();
            if(first != last){
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}
