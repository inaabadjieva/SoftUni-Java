package homework;

import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    private static final String RESOURCES_PATH = "/home/axltop/Projects/SoftUni-Java/5.Files-And-Streams/src/homework/resources/";

    public static void main(String[] args) {
        String file1 = RESOURCES_PATH + "sumLines.txt";
        String file2 = RESOURCES_PATH + "text.txt";
        String file3 = RESOURCES_PATH + "allCapitalsInput.txt";
        String zipFile = RESOURCES_PATH + "files.zip";

        String[] files = {file1, file2, file3};

        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            byte[] buffer = new byte[1024];

            for (String file : files) {
                File srcFile = new File(file);
                FileInputStream fis = new FileInputStream(srcFile);

                zos.putNextEntry(new ZipEntry(srcFile.getName()));
                int length;

                while ((length = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, length);
                }

                fis.close();
            }
        } catch (IOException ioe) {
            System.out.println("Error creating zip file: " + ioe);
        }
    }
}
