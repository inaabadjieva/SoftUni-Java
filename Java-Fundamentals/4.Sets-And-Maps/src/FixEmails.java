import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        while(true){
            String name = scanner.nextLine();
            if("stop".equals(name)){
                break;
            }
            String email = scanner.nextLine();
            int index = email.lastIndexOf('.');
            String domain = email.substring(index + 1);

            switch(domain){
                case "us":
                case"uk":
                case "com":
                    continue;
            }

            if(!result.containsKey(name)){
                result.put(name, email);
            } else {
                result.put(name, result.get(name) + email);
            }
        }

        for (String key : result.keySet()) {
            System.out.printf("%s -> %s\n", key, result.get(key));
        }
    }
}
