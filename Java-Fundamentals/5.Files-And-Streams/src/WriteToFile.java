import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        String pathIn = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/input.txt";
        String pathOut = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try(InputStream in = new FileInputStream(pathIn);
            OutputStream out = new FileOutputStream(pathOut)){
            int oneByte = in.read();

            while(oneByte >= 0){
                if(!symbols.contains((char) oneByte)){
                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
