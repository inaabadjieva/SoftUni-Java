import java.util.LinkedHashMap;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        while(true){
            String material = scanner.nextLine();
            if("stop".equals(material)){
                break;
            }
            Integer quantity = Integer.parseInt(scanner.nextLine());

            if(!result.containsKey(material)){
                result.put(material, quantity);
            } else {
                result.put(material, result.get(material) + quantity);
            }
        }

        for (String key : result.keySet()) {
            System.out.printf("%s -> %d\n", key, result.get(key));
        }
    }
}
