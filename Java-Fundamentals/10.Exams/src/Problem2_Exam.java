import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Problem2_Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Deque<List<Integer>> all = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        //read input
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");

            List<Integer> row = new ArrayList<>();
            for (String s : line) {
                row.add(Integer.parseInt(s));
            }
            all.add(row);
        }

        //iterate the queue
        while(all.size() > 0){
            List<Integer> current = all.peek();
            if(current.size() == 1){
                result.add(all.poll().get(0));
            }
            for (int j = 0; j < current.size() - 1; j++) {
                if(current.get(j) >= current.get(j + 1)){
                    all.getFirst().remove(j + 1);
                    j--;
                } else {
                    result.add(current.get(j));
                    all.getFirst().remove(j);
                    all.add(all.poll());
                    break;
                }
            }
        }

        //print result
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }
}
