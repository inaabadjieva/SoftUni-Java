import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EvaluateExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inFix = scanner.nextLine().split(" ");
        Deque<String> postFix = getPostFix(inFix);
        Deque<Double> result = new ArrayDeque<>();
        while(postFix.size() > 0){
            String current = postFix.poll();
            if(isNumeric(current)){
                result.push(Double.parseDouble(current));
            } else {
                double second = result.pop();
                double first = result.pop();
                result.push(Calculate(current, first, second));
            }
        }
        System.out.printf("%.2f", (double) result.pop());
    }

    private static double Calculate(String operator, double first, double second) {
        double result = 0;
        switch (operator){
            case "-":
                result = first - second;
                break;
            case "+":
                result = first + second;
                break;
            case "*":
                result = first * second;
                break;
            case "/":
                result = first / second;
                break;
        }
        return result;
    }


    public static Deque<String> getPostFix(String[] infix) {
        Deque<String> numsQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for(String token : infix){
            if(isNumeric(token)){ //if number
                numsQueue.add(token);
            } else{
                if(operatorStack.size() == 0) { //if empty
                    operatorStack.push(token);
                } else {
                    if(token.equals(")")){ //if closing parenthesis
                        String last = operatorStack.pop();
                        while (!last.equals("(")) {
                            numsQueue.add(last);
                            last = operatorStack.pop();
                        }
                    } else if(isCurrentPrior(token, operatorStack.peek())){ //check priority
                        operatorStack.push(token);
                    } else {
                        numsQueue.add(operatorStack.pop());
                        operatorStack.push(token);
                    }
                }
            }
        }
        while (operatorStack.size() > 0){
            numsQueue.add(operatorStack.pop());
        }

        return numsQueue;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static boolean isCurrentPrior(String current, String prev) {
        switch (current){
            case "-":
            case "+":
                if(prev.equals("(") )
                    return true;
                return false;
            case "*":
            case "/":
                if(prev.equals("-") || prev.equals("+") || prev.equals("("))
                    return true;
                return false;
            case "^":
            case "(":
                return true;
        }
        return true;
    }
}
