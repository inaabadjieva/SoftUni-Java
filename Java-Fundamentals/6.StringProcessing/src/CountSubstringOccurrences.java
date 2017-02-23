import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountSubstringOccurrences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine().toLowerCase();
        String word = reader.readLine().toLowerCase();

        int count = 0;
        while(true){
            if(text.contains(word)){
                count++;
            } else {
                break;
            }

            text = text.substring(text.indexOf(word) + 1);
        }

        System.out.println(count);
    }
}
