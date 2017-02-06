import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String pathIn = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/input.txt";
        String pathOut = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/output.txt";

        try(BufferedReader in = new BufferedReader(new FileReader(pathIn));
            PrintWriter out = new PrintWriter(new FileWriter(pathOut))) {
            int count = 1;
            String line = in.readLine();
            while(line != null){
                if(count % 3 == 0){
                    out.println(line);
                }
                count++;
                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
