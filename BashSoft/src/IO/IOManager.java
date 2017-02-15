package IO;

import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.File;
import java.util.LinkedList;

public class IOManager {
    public static void traverseDirectory(int depth){
        LinkedList<File> subFolders = new LinkedList<>();

        String path = SessionData.currentPath;
        int initialIndentation = path.split("/").length;

        File root = new File(path);

        subFolders.add(root);

        while(subFolders.size() != 0){
            File currentFolder = subFolders.removeFirst();
            int currentIndentation = currentFolder.toString().split("/").length - initialIndentation;

            if(depth - currentIndentation < 0){
                break;
            }

            OutputWriter.writeMessageOnNewLine(currentFolder.toString());

            if(currentFolder.listFiles() != null){
                for(File file : currentFolder.listFiles()){
                    if(file.isDirectory()){
                        subFolders.add(file);
                    } else {
                        int indexOfLastSlash = file.toString().lastIndexOf("/");
                        for (int i = 0; i < indexOfLastSlash; i++) {
                            OutputWriter.writeMessage("-");
                        }

                        OutputWriter.writeMessageOnNewLine(file.getName());
                    }
                }
            }

            System.out.println(currentFolder.toString());
        }
    }

    public static void createDirInCurrentFolder(String name){
        String path = getCurrentDirPath() + "/" + name;
        File file = new File(path);
        file.mkdir();
    }

    public static String getCurrentDirPath() {
        String currentPath = SessionData.currentPath;
        return currentPath;
    }

    public static void changeCurrentDirRelativePath(String relativePath){
        if("..".equals(relativePath)){
            //one dir up
            String currentPath = SessionData.currentPath;
            int index = currentPath.lastIndexOf("/");
            String newPath = currentPath.substring(0, index);
            SessionData.currentPath = newPath;
        } else {
            //go to a given dir
            String currentPath = SessionData.currentPath;
            currentPath += "/" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    private static void changeCurrentDirAbsolute(String absolutePath) {
        File file = new File(absolutePath);
        if(!file.exists()){
            OutputWriter.displayException(ExceptionMessages.INVALID_PATH);
            return;
        }

        SessionData.currentPath = absolutePath;
    }
}
