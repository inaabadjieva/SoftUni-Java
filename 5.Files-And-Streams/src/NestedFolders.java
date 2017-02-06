import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) {
        final String inputPath = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/Files-and-Streams";
        File file = new File(inputPath);
        ArrayDeque<File> queue = new ArrayDeque<>();
        queue.add(file);

        int counter = 1;
        while (!queue.isEmpty()) {
            File currentDir = queue.poll();

            File[] nestedFolders = currentDir.listFiles();
            for (File folder : nestedFolders) {
                if (folder.isDirectory()) {
                    queue.add(folder);
                    counter++;
                }
            }
            System.out.println(currentDir.getName());
        }
        System.out.println(counter + " Folders");
    }
}
