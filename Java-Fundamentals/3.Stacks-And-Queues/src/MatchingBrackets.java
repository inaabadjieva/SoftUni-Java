import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '('){
                stack.push(i);
            } else if(ch == ')') {
                int startIndex = stack.pop();
                String result = str.substring(startIndex, i+1);
                System.out.println(result);
            }
        }
    }
}
