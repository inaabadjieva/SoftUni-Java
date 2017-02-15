package IO;

import IO.IOManager;
import IO.OutputWriter;
import Judge.Tester;
import Repository.StudentsRepository;
import StaticData.SessionData;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String command = data[0];
        switch(command){
            case "open":
                tryOpenFile(input, data);
                break;
            case "mkdir":
                tryCreateDirectory(input, data);
                break;
            case "ls":
                tryTraverseFolders(input, data);
                break;
            case "cmp":
                tryCompareFiles(input, data);
                break;
            case "changeDirRel":
                tryChangeRelativePath(input, data);
                break;
            case "changeDirAbs":
                tryChangeAbsolutePath(input, data);
                break;
            case "readDB":
                tryReadDatabaseFromFile(input, data);
                break;
            case "filter":
                tryPrintFilteredStudents(input, data);
                break;
            case "order":
                tryPrintSortedStudents(input, data);
                break;
            case "download":
                //TODO
                break;
            case "downloadAsysc":
                //TODO
                break;
            case "show":
                tryShowWantedCourse(input, data);
                break;
            case "help":
                getHelp();
                break;
            default:
                displayInvalidCommandMsg(input);
                break;
        }
    }

    private static void tryPrintSortedStudents(String input, String[] data) {
        if(data.length != 3 && data.length != 4){
            displayInvalidCommandMsg(input);
            return;
        }

        String course = data[1];
        String compareType = data[2];

        if(data.length == 3){
            StudentsRepository.printOrderedStudents(course, compareType, null);
            return;
        }

        Integer numberOfStudents = Integer.valueOf(data[3]);

        if(data.length == 4){
            StudentsRepository.printOrderedStudents(course, compareType, numberOfStudents);
        }
    }

    private static void tryPrintFilteredStudents(String input, String[] data) {
        if(data.length != 3 && data.length != 4){
            displayInvalidCommandMsg(input);
            return;
        }

        String course = data[1];
        String filter = data[2];

        if(data.length == 3){
            StudentsRepository.printFilteredStudents(course, filter, null);
            return;
        }

        Integer numberOfStudents = Integer.valueOf(data[3]);

        if(data.length == 4){
            StudentsRepository.printFilteredStudents(course, filter, numberOfStudents);
        }
    }

    private static void tryShowWantedCourse(String input, String[] data) {
        if(data.length != 2 && data.length != 3){
            displayInvalidCommandMsg(input);
            return;
        }

        if(data.length == 2){
            String courseName = data[1];
            StudentsRepository.getStudentsByCourse(courseName);
            return;
        }

        if(data.length == 3){
            String courseName = data[1];
            String username = data[2];
            StudentsRepository.getStudentMarksInCourse(courseName, username);
            return;
        }
    }

    private static void tryReadDatabaseFromFile(String input, String[] data) throws IOException {
        if(data.length != 2){
            displayInvalidCommandMsg(input);
            return;
        }

        String fileName = data[1];
        StudentsRepository.initializeData(fileName);
    }

    private static void tryChangeAbsolutePath(String input, String[] data) {
        if(data.length != 2){
            displayInvalidCommandMsg(input);
            return;
        }

        String absolutePath = data[1];
        IOManager.changeCurrentDirRelativePath(absolutePath);
    }

    private static void tryChangeRelativePath(String input, String[] data) {
        if(data.length != 2){
            displayInvalidCommandMsg(input);
            return;
        }

        String relativePath = data[1];
        IOManager.changeCurrentDirRelativePath(relativePath);
    }

    private static void tryCompareFiles(String input, String[] data) {
        if(data.length != 3){
            displayInvalidCommandMsg(input);
            return;
        }

        String firstPath = data[1];
        String secondPath = data[2];
        Tester.compareContent(firstPath, secondPath);
    }

    private static void tryTraverseFolders(String input, String[] data) {
        if(data.length != 1 && data.length != 2){
            displayInvalidCommandMsg(input);
            return;
        }

        if(data.length == 1){
            IOManager.traverseDirectory(0);
        }

        if(data.length == 2){
            IOManager.traverseDirectory(Integer.parseInt(data[1]));
        }
    }

    private static void tryCreateDirectory(String input, String[] data) {
        if(data.length != 2){
            displayInvalidCommandMsg(input);
            return;
        }

        String folderName = data[1];
        IOManager.createDirInCurrentFolder(folderName);
    }

    private static void tryOpenFile(String input, String[] data) {
        if(data.length != 2){
            displayInvalidCommandMsg(input);
            return;
        }

        String fileName = data[1];
        String filePath = SessionData.currentPath + "/" + fileName;
        File file = new File(filePath);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            displayInvalidCommandMsg("Unable to open file.");
        }
    }

    private static void displayInvalidCommandMsg(String input) {
        String output = String.format("The command '%s' is invalid", input);
        OutputWriter.writeMessageOnNewLine(output);
    }

    public static void getHelp() {
        OutputWriter.writeMessageOnNewLine("mkdir path - make directory");
        OutputWriter.writeMessageOnNewLine("ls depth - traverse directory");
        OutputWriter.writeMessageOnNewLine("cmp path1 path2 - compare two files");
        OutputWriter.writeMessageOnNewLine("changeDirRel relativePath - change directory");
        OutputWriter.writeMessageOnNewLine("changeDir absolutePath - change directory");
        OutputWriter.writeMessageOnNewLine("readDb path - read students data base");
        OutputWriter.writeMessageOnNewLine("filterExcelent - filter excelent students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterExcelent path - filter excelent students (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("filterAverage - filter average students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterAverage path - filter average students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("filterPoor - filter low grade students (the output is on the console)");
        OutputWriter.writeMessageOnNewLine("filterPoor path - filter low grade students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("order - sort students in increasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("order path - sort students in increasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("decOrder - sort students in decreasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("decOrder path - sort students in decreasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("download pathOfFile - download file (saved in current directory)");
        OutputWriter.writeMessageOnNewLine("downloadAsync path - download file asynchronously (save in the current directory)");
        OutputWriter.writeMessageOnNewLine("help - get help");
        OutputWriter.writeEmptyLine();
    }
}
