import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4_Royal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Pattern pattern = Pattern.compile("^([a-zA-Z]+);(\\d+);(\\d+\\.?\\d*);([a-zA-Z]+)$");

        TreeMap<String,Long> employeeHours = new TreeMap<>();
        HashMap<String,TreeMap<String,Double>> teamDailyPayment = new HashMap<>();

        String str = "";
        while (!"Pishi kuf i da si hodim".equals(str = reader.readLine())){
            Matcher match = pattern.matcher(str);
            while (match.find()){
                String name = match.group(1);
                Long hours = Long.parseLong(match.group(2));
                Double dayPay = Double.parseDouble(match.group(3));
                String team = match.group(4);

                if (!employeeHours.containsKey(name)){
                    employeeHours.put(name, hours);
                    if (!teamDailyPayment.containsKey(team)){
                        teamDailyPayment.put(team, new TreeMap<>());
                    }
                } else {
                    break;
                }

                dayPay = (dayPay * hours) / 24.0;
                teamDailyPayment.get(team).put(name, dayPay);
            }
        }

        teamDailyPayment.entrySet().stream().sorted((e1, e2) -> {
            Double e1Money = 0.0 ;
            Double e2Money = 0.0 ;

            for (Double num : e1.getValue().values()) {
                e1Money += num * 30.0;
            }
            for (Double num : e2.getValue().values()) {
                e2Money += num * 30.0;
            }
            return e2Money.compareTo(e1Money);
        }).forEach(pair -> {
            System.out.println("Team - " + pair.getKey());
            pair.getValue().keySet().stream().sorted((e1,e2) -> {
                if (Long.compare(employeeHours.get(e2), employeeHours.get(e1)) == 0L){
                    Double b2 = pair.getValue().get(e2);
                    Double b1 = pair.getValue().get(e1);
                    return Double.compare(b2,b1);
                }
                return Long.compare(employeeHours.get(e2), employeeHours.get(e1));
            }).forEach(e -> {
                System.out.printf("$$$%s - %d - %f\n",e, employeeHours.get(e),pair.getValue().get(e));
            });
        });
    }
}
