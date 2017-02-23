import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FormattingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = reader.readLine().split("\\s+");
        int num1 = Integer.parseInt(input[0].trim());
        double num2 = Double.parseDouble(input[1].trim());
        double num3 = Double.parseDouble(input[2].trim());

        String binary = Integer.toString(num1, 2);
        while(binary.length() < 10){
            binary = "0" + binary;
        }
        if(binary.length() > 10){
            binary = binary.substring(0, 10);
        }

        sb.append("|").append(String.format("%-10X", num1));
        sb.append("|").append(String.format("%s", binary));
        sb.append("|").append(String.format("%10.2f", num2));
        sb.append("|").append(String.format("%-10.3f", num3));
        sb.append("|");

        System.out.println(sb);
    }
}
