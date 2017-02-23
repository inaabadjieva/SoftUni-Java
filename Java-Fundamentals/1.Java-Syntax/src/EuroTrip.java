import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double quantity = scanner.nextDouble();
        BigDecimal priceLeva = new BigDecimal(quantity * 1.20);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal total = priceLeva.multiply(exchangeRate);

        System.out.printf("%.2f marks", total);
    }
}
