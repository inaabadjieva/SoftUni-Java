import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(" ");
        List<String> allVehicles = new ArrayList<String>();
        int sold = 0;

        for (String str : inputData) {
            allVehicles.add(str);
        }

        while (true) {
            String[] line = scanner.nextLine().split(" ");
            if (line[0].equals("End")) {
                break;
            }

            String targetVehicle = line[0].toLowerCase().charAt(0) + line[2];

            if(allVehicles.contains(targetVehicle)){
                System.out.printf("Yes, sold for %d$\n",line[0].toLowerCase().charAt(0) * Integer.parseInt(line[2]));
                allVehicles.remove(targetVehicle);
                sold++;
            } else {
                System.out.println("No");
            }
        }
        System.out.println("Vehicles left: " + String.join(", ",allVehicles));
        System.out.println("Vehicles sold: " + sold);
    }
}
