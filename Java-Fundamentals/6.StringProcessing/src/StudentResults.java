import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class StudentResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, ArrayList<Double>> result = new TreeMap<>();

        int n = Integer.parseInt(reader.readLine());
        if(n == 0){
            return;
        }
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" - ");
            String name = line[0];
            ArrayList<Double> marks = new ArrayList<>();
            String[] marksStr = line[1].split(", ");
            for (String s : marksStr) {
                marks.add(Double.parseDouble(s));
            }

            if(!result.containsKey(name)){
                result.put(name, marks);
            }
        }

        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));

        for (String key : result.keySet()) {
            double sum = 0;
            for (Double mark : result.get(key)) {
                sum += mark;
            }
            double average = sum / result.get(key).size();

            ArrayList<Double> resultMarks = result.get(key);
            System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", key, resultMarks.get(0), resultMarks.get(1), resultMarks.get(2), average).replace(".", ","));
        }
    }
}
