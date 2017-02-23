import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3_RoyalFlush {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(reader.readLine());

        String str = "";
        for (int i = 0; i < n; i++) {
            str += reader.readLine();
        }

        List<String> ranks = Arrays.asList(new String[] { "10", "J", "Q", "K", "A" });
        List<String> suits = Arrays.asList(new String[] { "c", "d", "h", "s" });
        String[] outputSuits = new String[] { "Clubs", "Diamonds", "Hearts", "Spades" };

        int royalFlushes = 0;

        Pattern regexPattern = Pattern.compile("(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)");
        Matcher totalMatches = regexPattern.matcher(str);

        TreeMap<String, ArrayList<String>> currentCombinations = new TreeMap<>();

        while(totalMatches.find()) {
            String currentRank = totalMatches.group(1);
            String currentSuit = totalMatches.group(2);

            if(!currentCombinations.containsKey(currentSuit)){
                currentCombinations.put(currentSuit, new ArrayList<>());
            }

            if(currentCombinations.get(currentSuit).size() == 0) {
                if(ranks.indexOf(currentRank) == 0){
                    currentCombinations.get(currentSuit).add(currentRank);
                }
            } else {
                if(ranks.indexOf(currentRank) == currentCombinations.get(currentSuit).size()){
                    currentCombinations.get(currentSuit).add(currentRank);
                } else {
                    currentCombinations.get(currentSuit).clear();

                    if(ranks.indexOf(currentRank) == 0){
                        currentCombinations.get(currentSuit).add(currentRank);
                    }
                }
            }

            if(currentCombinations.get(currentSuit).size() == 5){
                System.out.println(String.format("Royal Flush Found - %s", outputSuits[suits.indexOf(currentSuit)]));
                currentCombinations.get(currentSuit).clear();
                royalFlushes++;
            }
        }
        System.out.println(String.format("Royal's Royal Flushes - %s.", royalFlushes));
    }
}
