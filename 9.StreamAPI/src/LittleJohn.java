import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleJohn {

    static final String BIG_ARROW = ">>>----->>";
    static final String MEDIUM_ARROW = ">>----->";
    static final String SMALL_ARROW = ">----->";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int countSmall = 0;
        int countMedium = 0;
        int countLarge = 0;
        for (int i = 0; i < 4; i++) {
            String input = reader.readLine();

            while (input.contains(BIG_ARROW)) {
                int index = input.indexOf(BIG_ARROW);
                input = input.substring(index + BIG_ARROW.length());
                countLarge++;
            }

            while (input.contains(MEDIUM_ARROW)) {
                int index = input.indexOf(MEDIUM_ARROW);
                input = input.substring(index + MEDIUM_ARROW.length());
                countMedium++;
            }

            while (input.contains(SMALL_ARROW)) {
                int index = input.indexOf(SMALL_ARROW);
                input = input.substring(index + SMALL_ARROW.length());
                countSmall++;
            }
        }

        String str = countSmall + "" + countMedium + "" + countLarge;
        String binary = Integer.toBinaryString(Integer.valueOf(str));
        binary += new StringBuilder(binary).reverse();

        int result = Integer.parseInt(binary, 2);
        System.out.println(result);
    }
}
