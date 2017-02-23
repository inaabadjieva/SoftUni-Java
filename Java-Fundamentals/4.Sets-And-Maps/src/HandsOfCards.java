import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> result = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();
            if("JOKER".equals(line)){
                break;
            }
            String name = line.split(": ")[0];
            String[] cards = line.split(": ")[1].split(",\\s+");

            if (!result.containsKey(name)) {
                result.put(name, new HashSet<>());
            }

            HashSet<String> currentHashSet = result.get(name);
            for (String card : cards) {
                currentHashSet.add(card);
            }

            result.put(name, currentHashSet);
        }

        for (String key : result.keySet()) {
            HashSet<String> cards = result.get(key);

            int score = calculatePoints(cards);

            System.out.println(key + ": " + score);
        }
    }

    private static int calculatePoints(HashSet<String> cards) {
        int score = 0;

        for (String card : cards) {
            String face = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1, card.length());

            int facePower = 0;
            int colorPower = 0;

            switch (face) {
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                    facePower = Integer.parseInt(face);
                    break;
                case "J": facePower = 11;
                    break;
                case "Q": facePower = 12;
                    break;
                case "K": facePower = 13;
                    break;
                case "A": facePower = 14;
                    break;
            }

            switch (color) {
                case "S": colorPower = 4;
                    break;
                case "H": colorPower = 3;
                    break;
                case "D": colorPower = 2;
                    break;
                case "C": colorPower = 1;
                    break;
            }
            score += facePower * colorPower;
        }
        return score;
    }

}
