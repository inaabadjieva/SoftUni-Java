import java.util.*;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        HashSet<String> vip = new HashSet<>();
        TreeSet<String> regular = new TreeSet<>();

        while(true){
            String line = scanner.nextLine();
            if("PARTY".equals(line)){
                break;
            }
            if(numbers.contains(Character.toString(line.charAt(0)))){
                vip.add(line);
            } else {
                regular.add(line);
            }
        }

        while(true){
            String line = scanner.nextLine();
            if("END".equals(line)){
                break;
            }
            if(numbers.contains(line.charAt(0))){
                vip.remove(line);
            } else {
                regular.remove(line);
            }
        }

        regular.addAll(vip);
        System.out.println(regular.size());
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
