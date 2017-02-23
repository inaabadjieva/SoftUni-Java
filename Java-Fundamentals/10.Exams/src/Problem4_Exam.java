import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Problem4_Exam {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, ArrayList<String>> playersOpponents = new LinkedHashMap<>();
        LinkedHashMap<String, ArrayList<Long>> playersWinsLoses = new LinkedHashMap<>();


        String input = "";
        while(!"osu!".equals(input = reader.readLine())){
            String[] tokens = input.split("<->");

            String[] player1Tokens = tokens[0].split(" ");
            long player1Scores = Long.parseLong(player1Tokens[0]);
            String player1 = player1Tokens[1];

            String[] player2Tokens = tokens[1].split(" ");
            long player2Scores = Long.parseLong(player2Tokens[1]);
            String player2 = player2Tokens[0];

            //playersWinsLoses
            if(!playersWinsLoses.containsKey(player1)){
                playersWinsLoses.put(player1, new ArrayList<>());
            }
            if(!playersWinsLoses.containsKey(player2)) {
                playersWinsLoses.put(player2, new ArrayList<>());
            }

            if(player1Scores > player2Scores){
                playersWinsLoses.get(player1).add(player1Scores - player2Scores);
                playersWinsLoses.get(player2).add(player2Scores - player1Scores);
            } else {
                playersWinsLoses.get(player1).add(player1Scores - player2Scores);
                playersWinsLoses.get(player2).add(player2Scores - player1Scores);
            }

            //playersOpponents
            if(!playersOpponents.containsKey(player1)){
                playersOpponents.put(player1, new ArrayList<>());
            }
            if(!playersOpponents.containsKey(player2)){
                playersOpponents.put(player2, new ArrayList<>());
            }
            playersOpponents.get(player1).add(player2);
            playersOpponents.get(player2).add(player1);
        }

//        playersScores.entrySet().stream()
//                .sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
//                .forEach(p -> {
//                    System.out.printf("%s - (%d)\n", p.getKey(), p.getValue());
//                    for (int i = 0; i < playersOpponents.get(p.getKey()).size(); i++) {
//                        System.out.printf("*   %s <-> %d\n", playersOpponents.get(p.getKey()).get(i), playersWinsLoses.get(p.getKey()).get(i));
//                    }
//                });

        playersWinsLoses.entrySet().stream()
                .sorted((p1, p2) -> {
                    long sum1 = p1.getValue().stream().mapToLong(e -> e).sum();
                    long sum2 = p2.getValue().stream().mapToLong(e -> e).sum();
                    return Long.compare(sum2, sum1);
                })
                .forEach(p -> {
                    System.out.printf("%s - (%d)\n", p.getKey(), p.getValue().stream().mapToLong(e -> e).sum());
                    for (int i = 0; i < playersOpponents.get(p.getKey()).size(); i++) {
                        System.out.printf("*   %s <-> %d\n", playersOpponents.get(p.getKey()).get(i), playersWinsLoses.get(p.getKey()).get(i));
                    }
                });
    }
}
