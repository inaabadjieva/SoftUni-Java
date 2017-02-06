import java.util.ArrayDeque;
import java.util.Scanner;

public class TruckTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<int[]> pumps = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] params = scanner.nextLine().split("\\s+");
            int petrol = Integer.parseInt(params[0]);
            int distance = Integer.parseInt(params[1]);

            int[] pump = new int[] { petrol, distance};
            pumps.add(pump);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            int totalPetrol = 0;
            for (int[] pump : pumps) {
                int stationPetrol = pump[0];
                int distance = pump[1];
                int petrolLeft = stationPetrol - distance;
                totalPetrol += petrolLeft;

                if (totalPetrol < 0){
                    break;
                }
            }
            if (totalPetrol >= 0) {
                index = i;
                break;
            }
            pumps.add(pumps.remove());
        }
        System.out.println(index);
    }
}
