import java.util.ArrayList;
import java.util.Scanner;

public class PlusRemoveTests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();
        int rowCount = 0;

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            matrix.add(rowCount, new ArrayList<>());
            for (int i = 0; i < line.length(); i++) {
                matrix.get(rowCount).add(line.charAt(i));
            }
            rowCount++;
            line = scanner.nextLine();
        }

        ArrayList<Integer> indexToBeRemoved = new ArrayList<>();

        for (int row = 1; row < matrix.size() - 1; row++) {
            for (int col = 1; col < matrix.get(row).size() - 1; col++) {

                char current = Character.toLowerCase(matrix.get(row).get(col));

                if (col < matrix.get(row - 1).size() &&
                        current == Character.toLowerCase(matrix.get(row - 1).get(col)) && //upper
                        col < matrix.get(row + 1).size() &&
                        current == Character.toLowerCase(matrix.get(row + 1).get(col)) && //down
                        col + 1 < matrix.get(row).size() &&
                        current == Character.toLowerCase(matrix.get(row).get(col + 1)) && //right
                        col - 1 >= 0 && col - 1 < matrix.get(row).size() &&
                        current == Character.toLowerCase(matrix.get(row).get(col - 1))) { //left

                    indexToBeRemoved.add(row);
                    indexToBeRemoved.add(col);

//                    matrix.get(row).set(col, ' ');
//                    matrix.get(row - 1).set(col, ' ');
//                    matrix.get(row).set(col + 1, ' ');
//                    matrix.get(row + 1).set(col, ' ');
//                    matrix.get(row).set(col - 1, ' ');
                }
            }
        }

        for (int i = 0; i < indexToBeRemoved.size(); i += 2) {
            int row = indexToBeRemoved.get(i);
            int col = indexToBeRemoved.get(i + 1);

            matrix.get(row).set(col, null);
            matrix.get(row - 1).set(col, null);
            matrix.get(row).set(col + 1, null);
            matrix.get(row + 1).set(col, null);
            matrix.get(row).set(col - 1, null);
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) != null) {
                    System.out.print(matrix.get(i).get(j));
                } else {
                    continue;
                }
            }
            System.out.println();
        }
    }
}
