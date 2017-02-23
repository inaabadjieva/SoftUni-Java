package homework;

import java.io.*;

public class CopyPicture {
    private static final String INPUT_PATH = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/src/homework/resources/bryan.jpg";
    private static final String OUTPUT_PATH = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/src/homework/resources/picture-copy.jpg";

    public static void main(String[] args) {
        File image = new File(INPUT_PATH);
        File copiedImage = new File(OUTPUT_PATH);
        try (FileInputStream in = new FileInputStream(image);
             FileOutputStream out = new FileOutputStream(copiedImage)) {
            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
