import javafx.scene.input.InputMethodTextRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnicodeChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length(); i++) {
            System.out.print(String.format("\\u%04x", (int)sb.charAt(i)));
        }
    }
}
