import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String pathIn = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/input.txt";
        String pathOut = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/output.txt";

        try(Scanner scanner = new Scanner(new FileInputStream(pathIn));
            PrintWriter out = new PrintWriter(new FileOutputStream(pathOut))) {
            while(scanner.hasNext()){
                if(scanner.hasNextInt()){
                    out.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
