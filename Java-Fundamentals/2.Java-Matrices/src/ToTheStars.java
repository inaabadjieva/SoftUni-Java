import java.util.Scanner;

public class ToTheStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstStar = scanner.nextLine().split(" ");
        String[] secondStar = scanner.nextLine().split(" ");
        String[] thirdStar = scanner.nextLine().split(" ");

        double[][] starsArgs = new double[3][2];
        starsArgs[0][0] = Double.parseDouble(firstStar[1]) - 1;
        starsArgs[0][1] = Double.parseDouble(firstStar[2]) - 1;

        starsArgs[1][0] = Double.parseDouble(secondStar[1]) - 1;
        starsArgs[1][1] = Double.parseDouble(secondStar[2]) - 1;

        starsArgs[2][0] = Double.parseDouble(thirdStar[1]) - 1;
        starsArgs[2][1] = Double.parseDouble(thirdStar[2]) - 1;

        String[] starNames = new String[3];
        starNames[0] = firstStar[0].toLowerCase();
        starNames[1] = secondStar[0].toLowerCase();
        starNames[2] = thirdStar[0].toLowerCase();

        String[] playerArgs = scanner.nextLine().split(" ");
        double playerCol = Double.parseDouble(playerArgs[0]);
        double playerRow = Double.parseDouble(playerArgs[1]);

        int turns = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= turns; i++) {
            double playerX = playerCol;
            double playerY = playerRow + i;

            boolean hasFound = false;
            for (int j = 0; j < starsArgs.length; j++) {
                double starX1 = starsArgs[j][0];
                double starY1 = starsArgs[j][1];
                double starX2 = starX1 + 2;
                double starY2 = starY1 + 2;

                if (playerX >= starX1 &&
                        playerX <= starX2 &&
                        playerY >= starY1 &&
                        playerY <= starY2) {
                    System.out.println(starNames[j]);
                    hasFound = true;
                    break;
                }
            }

            if (!hasFound)
                System.out.println("space");
        }
    }
}
