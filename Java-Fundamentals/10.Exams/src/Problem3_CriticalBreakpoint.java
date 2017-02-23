import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Problem3_CriticalBreakpoint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer[]> all = new ArrayList<>();

        String input = "";
        while(!"Break it.".equals(input = reader.readLine())){
            String[] tokens = input.split(" ");
            Integer[] line = new Integer[4];
            line[0] = Integer.parseInt(tokens[0]);
            line[1] = Integer.parseInt(tokens[1]);
            line[2] = Integer.parseInt(tokens[2]);
            line[3] = Integer.parseInt(tokens[3]);

            all.add(line);
        }

        boolean hasFoundBreakpoint = true;

        long x1 = all.get(0)[0];
        long y1 = all.get(0)[1];
        long x2 = all.get(0)[2];
        long y2 = all.get(0)[3];
        long neededRatio = Math.abs((x2 + y2) - (x1 + y1));

        for (int i = 1; i < all.size(); i++) {
            long currentX1 = all.get(i)[0];
            long currentY1 = all.get(i)[1];
            long currentX2 = all.get(i)[2];
            long currentY2 = all.get(i)[3];
            long currentRatio = Math.abs((currentX2 + currentY2) - (currentX1 + currentY1));

            if(neededRatio == 0){
                neededRatio = currentRatio;
            }

            if(currentRatio != neededRatio && currentRatio != 0L){
                hasFoundBreakpoint = false;
                break;
            }
        }

        if(hasFoundBreakpoint){
            for (Integer[] line : all) {
                System.out.println(String.format("Line: %s", Arrays.asList(line)));
            }
            BigInteger result = BigInteger.valueOf(neededRatio).pow(all.size());
            BigInteger criticalBreakpoint = result.remainder(BigInteger.valueOf(all.size()));

            System.out.println(String.format("Critical Breakpoint: %s", criticalBreakpoint));
        }
        else {
            System.out.println("Critical breakpoint does not exist.");
        }
    }
}
