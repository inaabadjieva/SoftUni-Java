import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringLength {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        StringBuilder sb = new StringBuilder(input);
        if(sb.length() > 20){
            System.out.println(sb.substring(0, 20));
        } else {
            sb.append(new String(new char[20 - input.length()]).replace("\0", "*"));
            System.out.println(sb);
        }
    }
}
