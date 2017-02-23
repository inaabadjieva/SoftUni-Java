import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> phonebook = new HashMap<>();

        while(true){
            String[] line = scanner.nextLine().split("-");
            if("search".equals(line[0])){
                break;
            }

            phonebook.put(line[0], line[1]);
        }

        while(true){
            String line = scanner.nextLine();
            if("stop".equals(line)){
                break;
            }

            if(phonebook.containsKey(line)){
                System.out.printf("%s -> %s\n", line, phonebook.get(line));
            } else {
                System.out.printf("Contact %s does not exist.\n", line);
            }
        }
    }
}
