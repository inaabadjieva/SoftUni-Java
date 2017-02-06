package homework;

import java.io.*;

public class AllCapitals {
    private final static String path = "/src/homework/resources/";

    public static void main(String[] args) throws FileNotFoundException {
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath + path + "/allCapitalsInput.txt";
        String output = projectPath + path + "/output.txt";
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        try(BufferedReader in = new BufferedReader(fileReader);
            PrintWriter out = new PrintWriter(output)){
            String line;
            while((line = in.readLine()) != null){
                line = line.toUpperCase();
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
