package homework;

import java.io.*;

public class MergeTwoFiles {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/homework/resources/";
    private static final String FIRST_FILE_PATH = PROJECT_PATH + "/words.txt";
    private static final String SECOND_FILE_PATH = PROJECT_PATH + "/sumLines.txt";
    private static final String OUTPUT_PATH = PROJECT_PATH + "/output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(FIRST_FILE_PATH));
        BufferedReader file2 = new BufferedReader(new FileReader(SECOND_FILE_PATH));

        try(PrintWriter out = new PrintWriter(OUTPUT_PATH)){
            String line;
            while ((line = file1.readLine()) != null) {
                out.println(line);
            }
            while ((line = file2.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
