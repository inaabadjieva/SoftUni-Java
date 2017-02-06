import java.util.LinkedHashMap;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Long> byCountry = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> byCityByCountry = new LinkedHashMap<>();

        while (true) {
            String[] commands = scanner.nextLine().split("\\|");
            if("report".equals(commands[0])){
                break;
            }
            String country = commands[1];
            String city = commands[0];
            long population = Long.parseLong(commands[2]);

            if (!byCityByCountry.containsKey(country)) {
                byCityByCountry.put(country, new LinkedHashMap<>());
                byCountry.put(country, 0L);
            }

            byCountry.put(country, byCountry.get(country) + population);

            if (!byCityByCountry.get(country).containsKey(city)) {
                byCityByCountry.get(country).put(city, 0L);
            }

            byCityByCountry.get(country).put(city, byCityByCountry.get(country).get(city) + population);
        }

        byCityByCountry.entrySet().stream()
                .sorted((c1,c2)-> byCountry.get(c2.getKey()).compareTo(byCountry.get(c1.getKey())))
                .forEach(country ->{
                    System.out.printf("%s (total population: %d)\n", country.getKey(), byCountry.get(country.getKey()));
                    country.getValue().entrySet().stream()
                            .sorted((t1,t2)-> t2.getValue().compareTo(t1.getValue()))
                            .forEach(city ->{
                        System.out.format("=>%s: %d\n", city.getKey(),city.getValue());
                    });
                });
    }
}
