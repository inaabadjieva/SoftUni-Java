import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        final String inputPath = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/input.txt";
        final String outputPath = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/output.txt";
        Path path = Paths.get(inputPath);
        Path output = Paths.get(outputPath);

        try {
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            Files.write(output, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
