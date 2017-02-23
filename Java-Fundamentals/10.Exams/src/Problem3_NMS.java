import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem3_NMS {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String text = "";
        while(!"---NMS SEND---".equals(line)){
            text += line;
            line = reader.readLine();
        }

        String delimiter = reader.readLine();

        List<String> words = new ArrayList<>();

        String word = "";
        for (int i = 0; i < text.length() - 1; i++) {
            if(text.toLowerCase().charAt(i) <= text.toLowerCase().charAt(i + 1)){
                word += text.charAt(i);
            } else {
                word += text.charAt(i);
                words.add(word);
                word = "";
            }

        }
        word += text.charAt(text.length()-1);
        words.add(word);

        delimiter = delimiter.equals("(space)") ? " " : delimiter;
        for (int i = 0; i < words.size() - 1; i++) {
            System.out.print(words.get(i) + delimiter);
        }
        System.out.print(words.get(words.size()-1));

    }
}
