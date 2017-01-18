import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int km = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();
        double totalPrice = 0;
        if(km < 20) {
            if(time.equals("day")) {
                totalPrice = 0.7 + (km * 0.79);
            } else {
                totalPrice = 0.7 + (km * 0.90);
            }
        } else if (km < 100) {
            totalPrice = km * 0.09;
        } else {
            totalPrice = km * 0.06;
        }

        System.out.printf("%.2f", totalPrice);
    }
}
