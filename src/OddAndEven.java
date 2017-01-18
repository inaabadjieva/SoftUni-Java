import java.util.Scanner;

public class OddAndEven {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String[] line = scanner.nextLine().split(" ");
       if(line.length % 2 != 0){
           System.out.printf("invalid length");
       } else {
           for (int i = 0; i < line.length; i+=2) {
               if(Integer.parseInt(line[i]) % 2 == 0 && Integer.parseInt(line[i+1]) % 2 == 0){
                   System.out.printf("%s, %s -> both are even\n", line[i], line[i+1]);
               } else if(Integer.parseInt(line[i]) % 2 != 0 && Integer.parseInt(line[i+1]) % 2 != 0){
                   System.out.printf("%s, %s -> both are odd\n", line[i], line[i+1]);
               } else {
                   System.out.printf("%s, %s -> different\n", line[i], line[i+1]);
               }
           }
       }
    }
}
