import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiclePark {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String[] vehicles = scanner.nextLine().split(" ");
        int sold = 0;

        String line = scanner.nextLine();
        while(!line.equals("End of customers!")){
            String[] params = line.split(" ");
            String vehicle = params[0].toLowerCase().charAt(0) + params[2];
            boolean soldOut = false;

            for (int i = 0; i < vehicles.length; i++) {
                if(vehicles[i].equals(vehicle)){
                    int price = (int) vehicle.charAt(0) * Integer.parseInt(params[2]);
                    System.out.printf("Yes, sold for %d$\n", price);
                    vehicles[i] = "";
                    soldOut = true;
                    sold++;
                    break;
                }
            }
            if(!soldOut){
                System.out.println("No");
            }

            line = scanner.nextLine();
        }

        List<String> left = new ArrayList<>();
        for (String vehicle : vehicles) {
            if(!vehicle.isEmpty()){
                left.add(vehicle);
            }
        }

        System.out.printf("Vehicles left: ");
        for (int i = 0; i < left.size(); i++) {
            if(i < left.size() - 1){
                System.out.printf("%s, ", left.get(i));
            } else {
                System.out.printf("%s\n", left.get(i));
            }
        }

        System.out.printf("Vehicles sold: %d", sold);

    }
}
