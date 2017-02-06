import java.util.Scanner;

public class FirstOddOrEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }

        String[] params = scanner.nextLine().split(" ");
        String type = params[2];
        int numOfElem = Integer.parseInt(params[1]);

        findOddOrEvenElements(array, type, numOfElem);
    }

    public static void findOddOrEvenElements(int[] numbers, String type, int num) {

        for (int i = 0; i < numbers.length; i++) {
            if (num <= 0) {
                break;
            }
            if (type.equals("odd")) {
                if (numbers[i] % 2 != 0) {
                    System.out.printf("%d ", numbers[i]);
                    num--;
                }
            } else {
                if (numbers[i] % 2 == 0) {
                    System.out.printf("%d ", numbers[i]);
                    num--;
                }
            }
        }
    }
}
