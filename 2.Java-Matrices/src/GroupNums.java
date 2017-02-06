import java.util.ArrayList;
import java.util.Scanner;

public class GroupNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        matrix.add(0, new ArrayList<>());
        matrix.add(1, new ArrayList<>());
        matrix.add(2, new ArrayList<>());

        for (String s : input) {
            int currentNum = Integer.parseInt(s);
            matrix.get(Math.abs(currentNum % 3)).add(currentNum);
        }

        for (ArrayList<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
