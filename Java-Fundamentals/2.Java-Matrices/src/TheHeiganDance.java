import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TheHeiganDance {
    private static final int CLOUD_DAMAGE = 3500;
    private static final int ERUPTION_DAMAGE = 6000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double heigan = 3000000d;
        boolean isHeiganDefeated = false;

        int player = 18500;
        boolean isPlayerDefeated = false;
        boolean hasCloud = false;
        String causeOfDeath = "";

        int[] playerPosition = {7, 7};

        double averageDamage = Double.parseDouble(reader.readLine());
        while (true) {
            String[] attackArgs = reader.readLine().split(" ");
            int row = Integer.parseInt(attackArgs[1]);
            int col = Integer.parseInt(attackArgs[2]);

            heigan -= averageDamage;
            isHeiganDefeated = heigan <= 0;

            if (hasCloud) {
                player -= CLOUD_DAMAGE;
                hasCloud = false;
                causeOfDeath = "Plague Cloud";
                isPlayerDefeated = player <= 0;
            }

            if (isHeiganDefeated || isPlayerDefeated) {
                break;
            }

            HashMap<String, Integer> damagePositions = getDamageArea(row, col);

            if (isPlayerInDamageZone(playerPosition, damagePositions)) {
                if (playerPosition[0] > 0 && playerPosition[0] == damagePositions.get("minRow")) {
                    playerPosition[0]--;
                } else if (playerPosition[0] < 14 && playerPosition[0] == damagePositions.get("maxRow")) {
                    playerPosition[0]++;
                } else if (playerPosition[1] > 0 && playerPosition[1] == damagePositions.get("minCol")) {
                    playerPosition[1]--;
                } else if (playerPosition[1] < 14 && playerPosition[1] == damagePositions.get("maxCol")) {
                    playerPosition[1]++;
                }
            }

            if (isPlayerInDamageZone(playerPosition, damagePositions)) {
                if (attackArgs[0].equals("Cloud")) {
                    player -= CLOUD_DAMAGE;
                    hasCloud = true;
                    causeOfDeath = "Plague Cloud";
                } else {
                    player -= ERUPTION_DAMAGE;
                    causeOfDeath = "Eruption";
                }
            }

            isPlayerDefeated = player <= 0;

            if (isPlayerDefeated) {
                break;
            }
        }

        if (isHeiganDefeated) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heigan);
        }

        if (isPlayerDefeated) {
            System.out.println("Player: Killed by " + causeOfDeath);
        } else {
            System.out.println("Player: " + player);
        }

        System.out.printf("Final position: %d, %d", playerPosition[0], playerPosition[1]);
    }

    private static HashMap<String, Integer> getDamageArea(int row, int col) {
        HashMap<String, Integer> damagePositions = new HashMap<>();
        damagePositions.put("minRow", row - 1);
        damagePositions.put("maxRow", row + 1);
        damagePositions.put("minCol", col - 1);
        damagePositions.put("maxCol", col + 1);
        return damagePositions;
    }

    private static boolean isPlayerInDamageZone(int[] playerPosition, HashMap<String, Integer> damagePositions) {
        if(playerPosition[0] >= damagePositions.get("minRow") &&
                playerPosition[0] <= damagePositions.get("maxRow") &&
                playerPosition[1] >= damagePositions.get("minCol") &&
                playerPosition[1] <= damagePositions.get("maxCol")){
            return true;
        }
        return false;
    }
}
