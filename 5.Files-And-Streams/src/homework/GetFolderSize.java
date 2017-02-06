package homework;

import java.io.File;

public class GetFolderSize {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/homework/";

    public static void main(String[] args) {
        File file = new File(PROJECT_PATH);

        System.out.println("Folder size: " + file.length());
    }
}
