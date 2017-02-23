import java.util.Scanner;

public class TerroristsWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char[] result = text.toCharArray();

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '|') {
                int power = 0;
                int indexEnd = 0;
                for (int j = i + 1; j < text.length(); j++) {
                    if (text.charAt(j) == '|') {
                        indexEnd = j;
                        break;
                    }
                    power += text.charAt(j);
                }
                int radius = power % 10;
                int start = 0;
                int end = text.length() - 1;
                if (i - radius > start) {
                    start = i - radius;
                }
                if (indexEnd + radius < end) {
                    end = indexEnd + radius;
                }

                for (int j = start; j <= end; j++) {
                    result[j] = '.';
                }

                i = indexEnd;
            }
        }
        System.out.println(new String(result));
    }
}
