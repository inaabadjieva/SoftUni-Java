import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Problem4_ChampionLeague {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String,Integer> teamWins = new TreeMap<>();
        TreeMap<String, TreeSet<String>> teamOpponents = new TreeMap<>();

        String input = "";
        while (!"stop".equals(input = reader.readLine())){
            String[] tokens = input.split(" \\| ");
            String team1 = tokens[0].trim();
            String team2 = tokens[1].trim();
            String[] result1 = tokens[2].trim().split(":");
            String[] result2 = tokens[3].trim().split(":");

            int homeTeam1 = Integer.parseInt(result1[0]);
            int awayTeam2 = Integer.parseInt(result1[1]);
            int homeTeam2 = Integer.parseInt(result2[0]);
            int awayTeam1 = Integer.parseInt(result2[1]);

            if (!teamOpponents.containsKey(team1))
                teamOpponents.put(team1, new TreeSet<>());
            if (!teamOpponents.containsKey(team2))
                teamOpponents.put(team2, new TreeSet<>());
            if (!teamWins.containsKey(team1))
                teamWins.put(team1, 0);
            if (!teamWins.containsKey(team2))
                teamWins.put(team2, 0);

            teamOpponents.get(team1).add(team2);
            teamOpponents.get(team2).add(team1);

            if (homeTeam1 + awayTeam1 > homeTeam2 + awayTeam2){
                teamWins.put(team1, teamWins.get(team1) + 1);
            } else if (homeTeam1 + awayTeam1 < homeTeam2 + awayTeam2) {
                teamWins.put(team2, teamWins.get(team2) + 1);
            } else {
                if (awayTeam1 > awayTeam2){
                    teamWins.put(team1, teamWins.get(team1) + 1);
                } else {
                    teamWins.put(team2, teamWins.get(team2) + 1);
                }
            }
        }

        teamWins.entrySet().stream()
                .sorted((t1, t2) -> Integer.compare(t2.getValue(), t1.getValue()))
                .forEach(t -> {
                    System.out.println(t.getKey());
                    System.out.println("- Wins: " + t.getValue());
                    if (teamOpponents.containsKey(t.getKey()))
                        System.out.printf("- Opponents: %s\n", String.join(", ", teamOpponents.get(t.getKey())
                                .stream().collect(Collectors.toList())));
                });
    }
}
