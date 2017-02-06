import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> player1 = getPlayerNums(scanner);
        LinkedHashSet<Integer> player2 = getPlayerNums(scanner);

        for (int i = 0; i < 50; i++) {
            if(player1.isEmpty() || player2.isEmpty()){
                break;
            }
            int card1 = player1.iterator().next();
            player1.remove(card1);

            int card2 = player2.iterator().next();
            player2.remove(card2);

            if(card1 > card2){
                player1.add(card1);
                player1.add(card2);
            } else if(card2 > card1){
                player2.add(card1);
                player2.add(card2);
            } else {
                continue;
            }
        }

        if(player1.size() > player2.size()){
            System.out.println("First player win!");
        } else if(player1.size() < player2.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw");
        }
    }

    public static LinkedHashSet<Integer> getPlayerNums(Scanner scanner) {
        String[] line = scanner.nextLine().split(" ");
        LinkedHashSet<Integer> playerNums = new LinkedHashSet<>();

        for (String s : line) {
            playerNums.add(Integer.parseInt(s));
        }
        return playerNums;
    }
}
