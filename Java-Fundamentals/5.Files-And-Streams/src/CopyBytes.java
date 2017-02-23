import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {
        String pathIn = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/input.txt";
        String pathOut = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/output.txt";

        try(InputStream in = new FileInputStream(pathIn);
            OutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = in.read();

            while(oneByte >= 0){
                if(oneByte == ' ' || oneByte == '\n'){
                    out.write(oneByte);
                } else{
                    String decimal = String.valueOf(oneByte);
                    for (char c : decimal.toCharArray()) {
                        out.write(c);
                    }
                }
                oneByte = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
