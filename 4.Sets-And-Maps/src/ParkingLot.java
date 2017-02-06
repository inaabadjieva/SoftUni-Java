import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> parking = new HashSet<>();
        String[] line = scanner.nextLine().split(", ");
        while(!"END".equals(line[0])){
            String direction = line[0];
            String number = line[1];
            if("IN".equals(direction)){
                parking.add(number);
            } else {
                parking.remove(number);
            }
            line = scanner.nextLine().split(", ");
        }

        if(parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else{
            for (String number : parking) {
                System.out.println(number);
            }
        }
    }
}
