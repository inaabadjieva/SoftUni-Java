import java.util.Scanner;

public class TerroristsWinExer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder inputText = new StringBuilder(scanner.nextLine());

        while(true){
            int firstPipeIndex = inputText.indexOf("|");
            if(firstPipeIndex != -1){
                int lastPipeIndex = inputText.indexOf("|", firstPipeIndex + 1);
                String bombContent = inputText.substring(firstPipeIndex + 1, lastPipeIndex);
                int bombPower = getBombPower(bombContent);

                int startIndex = Math.max(0, firstPipeIndex - bombPower);
                int endIndex = Math.min(lastPipeIndex + bombPower, inputText.length() - 1);

                while(startIndex <= endIndex){
                    inputText.setCharAt(startIndex, '.');
                    startIndex++;
                }
            } else {
                break;
            }
        }
        System.out.println(inputText);
    }

    private static int getBombPower(String bombContent) {
        int sum = 0;

        for (int i = 0; i < bombContent.length(); i++) {
            sum += bombContent.charAt(i);
        }

//        for (char symbol : bombContent.toCharArray()) {
//            sum += symbol;
//        }
        return sum % 10;
    }
}
