import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4_RoyalAccounting {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, TreeMap<String, double[]>> teams = new HashMap<>();

        Pattern pattern = Pattern.compile("^([a-zA-Z]+);(-?\\d+);(-?\\d+\\.?\\d*);([a-zA-Z]+)$");

        String input = "";
        while(!"Pishi kuf i da si hodim".equals(input = reader.readLine())){
            Matcher matcher = pattern.matcher(input);
            if(matcher.find()){
                String name = matcher.group(1);
                double hours = Double.parseDouble(matcher.group(2));
                double money = Double.parseDouble(matcher.group(3));
                String team = matcher.group(4);

                double salary = (money * hours) / 24 * 30;
                double dailyIncome = money * hours / 24.0;

                if(!teams.containsKey(team)){
                    teams.put(team, new TreeMap<>());
                }
                boolean nameExists = false;
                for (String key : teams.keySet()) {
                    for (String s : teams.get(key).keySet()) {
                        if(name.equals(s)){
                            nameExists = true;
                        }
                    }
                }
                if(!nameExists){
                    teams.get(team).put(name, new double[4]);
                    teams.get(team).get(name)[0] = hours;
                    teams.get(team).get(name)[1] = money;
                    teams.get(team).get(name)[2] = salary;
                    teams.get(team).get(name)[3] = dailyIncome;
                }
            }
        }

        teams.entrySet().stream()
                .sorted((t1, t2) -> {
                    double sum1 = t1.getValue().values().stream().mapToDouble(e -> e[2]).sum();
                    double sum2 = t2.getValue().values().stream().mapToDouble(e -> e[2]).sum();
                    return Double.compare(sum2, sum1);
                })
                .forEach(t -> {
                    if(t.getValue().size() > 0){
                        System.out.println("Team - " + t.getKey());
                        t.getValue().entrySet().stream()
                                .sorted((e1, e2) -> Double.compare(e2.getValue()[3], e1.getValue()[3]))
                                .sorted((e1, e2) -> Long.compare((long)e2.getValue()[0], (long)e1.getValue()[0]))

                                .forEach(e -> System.out.printf("$$$%s - %d - %.6f\n", e.getKey(), (int) e.getValue()[0], e.getValue()[3]));
                    }
                });
    }
}
