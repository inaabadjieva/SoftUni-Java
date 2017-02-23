import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String params = scanner.nextLine();
        String regex = "(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(params);
        int degrees = 0;

        if(match.find()) {
            degrees = Integer.parseInt(match.group(0));
        }

        ArrayList<String> words = new ArrayList<>();
        int maxLength = 0;

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            words.add(line);
            if(line.length() > maxLength){
                maxLength = line.length();
            }
            line = scanner.nextLine();
        }
        //fill the matrix
        char[][] matrix = new char[words.size()][maxLength];
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < maxLength; j++) {
                if(j < words.get(i).length()){
                    matrix[i][j] = words.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        switch(degrees % 360){
            case 0: print0Degrees(matrix);
            break;
            case 90: print90Degrees(matrix);
            break;
            case 180: print180Degrees(matrix);
            break;
            case 270: print270Degrees(matrix);
        }
    }

    private static void print270Degrees(char[][] matrix) {
        for (int col = matrix[1].length - 1; col >= 0 ; col--) {
            for (int row = 0; row < matrix.length; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void print180Degrees(char[][] matrix) {
        for (int row = matrix.length - 1; row >= 0 ; row--) {
            for (int col = matrix[1].length - 1; col >= 0 ; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void print90Degrees(char[][] matrix) {
        for (int col = 0; col < matrix[1].length; col++) {
            for (int row = matrix.length - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void print0Degrees(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
