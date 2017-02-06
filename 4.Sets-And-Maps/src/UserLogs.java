import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> result = new TreeMap<>();

        while(true){
            String[] line = scanner.nextLine().split(" ");
            if("end".equals(line[0])){
                break;
            }

            String ip = line[0].substring(3);
            String username = line[2].substring(5);

            if(!result.containsKey(username)){
                result.put(username, new LinkedHashMap<>());
            }

            if(!result.get(username).containsKey(ip)){
                result.get(username).put(ip, 0);
            }

            result.get(username).put(ip, result.get(username).get(ip) + 1);
        }
        for (String username : result.keySet()) {
            System.out.println(username + ": ");
            LinkedHashMap<String, Integer> ips = result.get(username);
            int count = ips.size();
            for (String ip : ips.keySet()) {
                if(count > 1){
                    System.out.printf("%s => %d, ", ip, ips.get(ip));
                } else {
                    System.out.printf("%s => %d.\n", ip, ips.get(ip));
                }
                count--;
            }
        }
    }
}
