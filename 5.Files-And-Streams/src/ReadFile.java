import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/input.txt";

        try(FileInputStream fis = new FileInputStream(path)){
            int oneByte = fis.read();

            while(oneByte >= 0){
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
