import java.util.ArrayDeque;
import java.util.Scanner;

public class ReversingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Character> reversed = new ArrayDeque<>();
        for (char ch : input.toCharArray()) {
            reversed.push(ch);
        }

        while(!reversed.isEmpty()){
            System.out.print(reversed.pop());
        }
    }
}
