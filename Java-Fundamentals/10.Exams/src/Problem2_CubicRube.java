import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2_CubicRube {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long[][][] cube = new long[n][n][n];
        long count = (long)Math.pow(n, 3);
        long sum = 0L;

        String line = "";
        while(!"Analyze".equals(line = reader.readLine())){
            String[] tokens = line.split("\\s+");
            int dimen1 = Integer.parseInt(tokens[0]);
            int dimen2 = Integer.parseInt(tokens[1]);
            int dimen3 = Integer.parseInt(tokens[2]);
            long value = Long.parseLong(tokens[3]);

            if(isInside(cube, dimen1, dimen2, dimen3)){
                sum += value;
                if(value != 0){
                    count--;
                }
            }
        }

        System.out.println(sum);
        System.out.println(count);
    }

    private static boolean isInside(long[][][] cube, int dimen1, int dimen2, int dimen3) {
        if(dimen1 >= 0 && dimen1 < cube.length &&
                dimen2 >= 0 && dimen2 < cube[0].length &&
                dimen3 >= 0 && dimen3 < cube[0][0].length){
            return true;
        }

        return false;
    }
}
