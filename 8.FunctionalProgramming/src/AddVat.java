import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class AddVat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");

        List<Double> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Double.parseDouble(s));
        }

        UnaryOperator<Double> addVat = x -> x * 1.2;
        System.out.println("Prices with VAT:");
        for (Double str : numbers) {
            System.out.println(String.format("%1$.2f",
                    addVat.apply(str)).replace('.', ','));
        }
    }
}
