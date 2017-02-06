package homework;

import java.io.*;

public class LineNumbers {
    private static final String path = "/src/homework/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path + "/lineNumbersInput.txt";
        String output = projectPath + path + "/output.txt";
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        try(BufferedReader in = new BufferedReader(fileReader);
            PrintWriter out = new PrintWriter(output)){
            String line;
            String printLine;
            int count = 1;
            while((line = in.readLine()) != null){
                printLine = count + ". " + line;
                out.println(printLine);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
