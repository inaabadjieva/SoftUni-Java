import java.util.Scanner;

public class GameOfNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int players = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < players; i++) {
            String name = scanner.nextLine();
            int points = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < name.length(); j++) {
                if((int) name.charAt(j) % 2 == 0){
                    points += (int) name.charAt(j);
                } else {
                    points -= (int) name.charAt(j);
                }
            }
            if(points > max){
                max = points;
                winner = name;
            }
        }
        System.out.printf("The winner is %s - %d points", winner, max);
    }
}
