import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1_Royalism {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        List<String> royalists = new ArrayList<>();
        List<String> others = new ArrayList<>();
        for (String s : input) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += (int) c;
                if(sum > 26){
                    while(sum > 26){
                        sum -= 26;
                    }
                }
            }
            if(sum == 18){
                royalists.add(s);
            } else {
                others.add(s);
            }
        }
        if(royalists.size() > 0 && royalists.size() >= others.size()){
            System.out.println("Royalists - " + royalists.size());
            for (String royalist : royalists) {
                System.out.println(royalist);
            }
            System.out.println("All hail Royal!");
        } else {
            for (String other : others) {
                System.out.println(other);
            }
            System.out.println("Royalism, Declined!");
        }
    }
}
