import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder text = new StringBuilder();
        Deque<String> commands = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]){
                case "1":
                    String toBeAdded = line[1];
                    text.append(toBeAdded);

                    commands.push("1" + " " + toBeAdded);
                    break;

                case "2":
                    int count = Integer.parseInt(line[1]);
                    String toBeRemoved = text.substring(text.length() - count, text.length());
                    text.replace(text.length() - count, text.length(), "");
                    commands.push("2" + " " + toBeRemoved);
                    break;

                case "3":
                    int index = Integer.parseInt(line[1]);
                    System.out.println(text.charAt(index - 1));
                    break;

                case "4":
                    if (commands.size() == 0) {
                        continue;
                    }
                    String[] lastCommand = commands.pop().split(" ");
                    String commandType = lastCommand[0];
                    String argument = lastCommand[1];

                    switch (commandType) {
                        case "1":
                            int length = argument.length();
                            text.replace(text.length() - length, text.length(), "");
                            break;
                        case "2":
                            text.append(argument);
                            break;
                    }
            }
        }
    }
}
