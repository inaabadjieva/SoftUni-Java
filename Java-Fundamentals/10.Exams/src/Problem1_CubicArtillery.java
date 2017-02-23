import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1_CubicArtillery {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(reader.readLine());

        Deque<Integer> weapons = new ArrayDeque<>();
        ArrayDeque<String> bunkers = new ArrayDeque<>();

        String input = "";
        while (!"Bunker Revision".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            int weapon = 0;
            for (int i = 0; i < tokens.length; i++) {
                if (!tokens[i].matches("[a-zA-Z]")) {
                    weapon = Integer.parseInt(tokens[i]);
                    int sum = 0;
                    for (Integer integer : weapons) {
                        sum += integer;
                    }
                    if (weapon > capacity) {
                        printResult(bunkers.poll(), weapons);
                        weapons.clear();
                    } else if (sum + weapon > capacity && bunkers.size() > 1) {
                        printResult(bunkers.poll(), weapons);
                        weapons.clear();
                        weapons.add(weapon);
                    } else if (weapon <= capacity - sum) {
                        weapons.add(weapon);
                    } else if (weapon > capacity - sum && bunkers.size() == 1) {
                        while (weapon > capacity - sum) {
                            weapons.pop();
                            sum = 0;
                            for (Integer integer : weapons) {
                                sum += integer;
                            }
                        }
                        weapons.add(weapon);
                    }
                } else {
                    bunkers.add(tokens[i]);
                }
            }
        }
    }

    private static void printResult(String bunker, Deque<Integer> weapons) {
        if (weapons.size() != 0){
            System.out.print(bunker + " -> ");
            int index = 0;
            for (Integer integer : weapons) {
                if (index != weapons.size() - 1){
                    System.out.print(integer + ", ");
                } else {
                    System.out.println(integer);
                }
                index++;
            }
        } else {
            System.out.println(bunker + " -> Empty");
        }
    }
}
