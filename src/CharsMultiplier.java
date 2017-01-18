import java.util.Scanner;

public class CharsMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        int sum = sumChars(str1, str2);
        System.out.println(sum);
    }
    public static int sumChars(String str1, String str2) {
        int sum = 0;
        int maxLength = Math.max(str1.length(), str2.length());
        int minLength = Math.min(str1.length(), str2.length());

        for (int i = 0; i < minLength; i++) {
            sum += (int) (str1.charAt(i)) * (int) (str2.charAt(i));
        }

        if(str1.length() != str2.length()){
            String longerStr = "";
            if(str1.length() > str2.length()){
                longerStr = str1;
            } else {
                longerStr = str2;
            }
            for (int i = minLength; i < maxLength; i++) {
                sum += (int) (longerStr.charAt(i));
            }
        }
        return sum;
    }
}
