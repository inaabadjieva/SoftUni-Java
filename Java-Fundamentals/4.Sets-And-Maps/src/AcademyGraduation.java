import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<String, Double> result = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double sum = 0;
            String[] grades = scanner.nextLine().split(" ");
            for (String grade : grades) {
                sum += Double.parseDouble(grade);
            }

            result.put(name, sum/grades.length);
        }
        for (String key : result.keySet()) {
            System.out.printf("%s is graduated with %s\n", key, result.get(key));
        }
    }
}
